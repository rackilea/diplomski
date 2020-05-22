import javax.sound.sampled.*;
import javax.sound.sampled.AudioFormat.Encoding;
import java.io.*;
import java.nio.*;

static double[] readFully(File file)
throws UnsupportedAudioFileException, IOException {
    AudioInputStream in = AudioSystem.getAudioInputStream(file);
    AudioFormat     fmt = in.getFormat();

    byte[] bytes;
    try {
        if(fmt.getEncoding() != Encoding.PCM_SIGNED) {
            throw new UnsupportedAudioFileException();
        }

        // read the data fully
        bytes = new byte[in.available()];
        in.read(bytes);
    } finally {
        in.close();
    }

    int   bits = fmt.getSampleSizeInBits();
    double max = Math.pow(2, bits - 1);

    ByteBuffer bb = ByteBuffer.wrap(bytes);
    bb.order(fmt.isBigEndian() ?
        ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);

    double[] samples = new double[bytes.length * 8 / bits];
    // convert sample-by-sample to a scale of
    // -1.0 <= samples[i] < 1.0
    for(int i = 0; i < samples.length; ++i) {
        switch(bits) {
            case 8:  samples[i] = ( bb.get()      / max );
                     break;
            case 16: samples[i] = ( bb.getShort() / max );
                     break;
            case 32: samples[i] = ( bb.getInt()   / max );
                     break;
            case 64: samples[i] = ( bb.getLong()  / max );
                     break;
            default: throw new UnsupportedAudioFileException();
        }
    }

    return samples;
}