import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;

public class AudioWrite2New {

    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException {

        Scanner in = new Scanner(System.in);
        final double SAMPLING_RATE = 44100;             // Audio sampling rate
        int time = in.nextInt();                        //Time specified by user in milliseconds
        int time2 = in.nextByte();
        int frequency1 = in.nextInt();                   //Frequency1 specified by the user in hz
        int frequency2 = in.nextInt();                   //Frequency2 specified by the user in hz

        float buffer[] = new float[((int) (time * SAMPLING_RATE))/1000];   //Size of buffer[], which in case of 10 seconds is 441000
        float buffer1[] = new float[((int) (time * SAMPLING_RATE))/1000];   //Size of buffer1[], which in case of 10 seconds is 441000

        //for (int a = 1; a <= time2 / 2; a++) {
        for (int sample = 0; sample < buffer.length; sample++) {
            double cycle = sample / SAMPLING_RATE;                  //Fraction of cycle between samples
            buffer[sample] = (float) (Math.sin(2 * Math.PI * frequency1 * cycle));
            //buffer1[sample] = (float) (Math.sin(2 * Math.PI * frequency2 * cycle));
        }
        for (int sample = 0; sample < buffer1.length; sample++) {
            double cycle = sample / SAMPLING_RATE;                  //Fraction of cycle between samples
            //buffer[sample] = (float) (Math.sin(2 * Math.PI * frequency1 * cycle));
            buffer1[sample] = (float) (Math.sin(2 * Math.PI * frequency2 * cycle));
        }
        //System.out.println(buffer[1]);
        byte byteBuffer[] = new byte[buffer.length * 2];            //Size of byteBuffer, in this case 882000
        byte byteBuffer1[] = new byte[buffer1.length * 2];            //Size of byteBuffer, in this case 882000

        int count = 0;
        for (int i = 0; i < byteBuffer.length; i++) {
            final int x = (int) (buffer[count++] * Short.MAX_VALUE);
            byteBuffer[i++] = (byte) x;
            byteBuffer[i] = (byte) (x / 256);
        }

        count = 0;
        for (int i = 0; i < byteBuffer1.length; i++) {
            final int x = (int) (buffer1[count++] * Short.MAX_VALUE);
            byteBuffer1[i++] = (byte) x;
            byteBuffer1[i] = (byte) (x / 256);
        }

        int iterations = (1000*time2)/(2*time);
        byte[] merge = new byte[iterations*(byteBuffer.length + byteBuffer1.length)];
        for (int i = 0; i<iterations; i++)
        {
            //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
            //For merging the two frequencies
            System.arraycopy(byteBuffer, 0, merge, 0+i*(byteBuffer.length + byteBuffer1.length), byteBuffer.length);
            System.arraycopy(byteBuffer1, 0, merge, byteBuffer.length+i*(byteBuffer.length + byteBuffer1.length), byteBuffer1.length);
        }

        File out = new File("E:/RecordAudio17.wav"); //The path where user want the file data to be written

        //Construct an audio format, using 44100hz sampling rate, 16 bit samples, mono, and big 
        // endian byte ordering
        AudioFormat format = new AudioFormat((float) SAMPLING_RATE, 16, 1, true, false);

        // It uses bytebuffer as its buffer array that contains bytes that may be read from the stream.
        ByteArrayInputStream bais = new ByteArrayInputStream(merge);

        //Constructs an audio input stream that has the requested format and length in sample frames, using audio data 
        //from the specified input stream.
        AudioInputStream audioInputStream = new AudioInputStream(bais, format, (buffer1.length + buffer.length) * (time2/4));

        //Writes a stream of bytes representing an audio file of the specified file type to the external file provided.
        AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, out);

        //}
        //audioInputStream.close();       //Closes this audio input stream
    }
}