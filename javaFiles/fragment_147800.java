import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class WavePlay {

    public static void main(String[] args) {

        float duration = 1f; // seconds
        int sampleRate = 44100;
        int numSamples = (int) (duration * sampleRate);
        double sample[] = new double[numSamples];

        SourceDataLine line = null;
        int freqOfTone = 300;

        double[] original;

        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                sampleRate, 8, 1, 1, sampleRate, true);

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        double increment = 2 * Math.PI * freqOfTone / sampleRate;
        double angle = 0;

        for (int i = 0; i < numSamples; ++i) {
            sample[i] = (Math.sin(angle)) * Byte.MAX_VALUE;
            angle += increment;
        }

        final double generatedSnd[] = new double[200000];

        original = new double[generatedSnd.length];

        for (int i = 0; i < 20000; i++) {
            generatedSnd[i] = sample[i % sample.length];

            original[i] = generatedSnd[i];

        }

        // Echo

        int delaySamples = 20000;

        float decay = 0.8f;

        double maxValue = Byte.MAX_VALUE;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < generatedSnd.length; i++) {

                if (i < delaySamples * (j + 1)) {
                    continue;
                }

                generatedSnd[i] += original[i - delaySamples * (j + 1)] * decay;
                if(generatedSnd[i] > maxValue){
                    maxValue = generatedSnd[i]; 
                }

            }

            decay *= 0.5;
        }

        //scale to fit byte length (8 bit)
        byte[] out = new byte[generatedSnd.length];

        for (int i = 0; i < out.length; i++) {
            out[i] = (byte)(Byte.MAX_VALUE * generatedSnd[i] / maxValue);
        }

        // play

        InputStream source = new ByteArrayInputStream(out);

        int numRead = 0;
        byte[] buf = new byte[line.getBufferSize()];

        line.start();
        // read and play chunks of the audio
        try {
            while ((numRead = source.read(buf, 0, buf.length)) >= 0) {
                int offset = 0;
                while (offset < numRead)
                    offset += line.write(buf, offset, numRead - offset);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        line.drain();
        line.stop();
        line.close();

        System.exit(0);
    }

}