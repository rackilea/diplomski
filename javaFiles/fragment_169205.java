package me.justinb.mediapad.audio;

import de.jarnbjo.ogg.FileStream;
import de.jarnbjo.ogg.LogicalOggStream;
import org.jitsi.impl.neomedia.codec.audio.opus.Opus;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Collection;

public class OpusAudioPlayer {
    private static int BUFFER_SIZE = 1024 * 1024;
    private static int INPUT_BITRATE = 48000;
    private static int OUTPUT_BITRATE = 48000;

    private FileStream oggFile;
    private long opusState;

    private ByteBuffer decodeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    private AudioFormat audioFormat = new AudioFormat(OUTPUT_BITRATE, 16, 1, true, false);

    public static void main(String[] args) {
        try {
            OpusAudioPlayer opusAudioPlayer = new OpusAudioPlayer(new File("test.opus"));
            opusAudioPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OpusAudioPlayer(File audioFile) throws IOException {
        oggFile = new FileStream(new RandomAccessFile(audioFile, "r"));
        opusState = Opus.decoder_create(INPUT_BITRATE, 1);
    }

    private byte[] decode(byte[] packetData) {
        int frameSize = Opus.decoder_get_nb_samples(opusState, packetData, 0, packetData.length);
        int decodedSamples = Opus.decode(opusState, packetData, 0, packetData.length, decodeBuffer.array(), 0, frameSize, 0);
        if (decodedSamples < 0) {
            System.out.println("Decode error: " + decodedSamples);
            decodeBuffer.clear();
            return null;
        }
        decodeBuffer.position(decodedSamples * 2); // 2 bytes per sample
        decodeBuffer.flip();

        byte[] decodedData = new byte[decodeBuffer.remaining()];
        decodeBuffer.get(decodedData);
        decodeBuffer.flip();
        return decodedData;
    }

    public void play() {
        int totalDecodedBytes = 0;
        try {
            SourceDataLine speaker = AudioSystem.getSourceDataLine(audioFormat);
            speaker.open();
            speaker.start();
            for (LogicalOggStream stream : (Collection<LogicalOggStream>) oggFile.getLogicalStreams()) {
                byte[] nextPacket = stream.getNextOggPacket();
                while (nextPacket != null) {
                    byte[] decodedData = decode(nextPacket);
                    if(decodedData != null) {
                        // Write packet to SourceDataLine
                        speaker.write(decodedData, 0, decodedData.length);
                        totalDecodedBytes += decodedData.length;
                    }
                    nextPacket = stream.getNextOggPacket();
                }
            }
            speaker.drain();
            speaker.close();
            System.out.println(String.format("Decoded to %d bytes", totalDecodedBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}