import java.net.URL;

        import javax.sound.sampled.AudioFormat;
        import javax.sound.sampled.AudioInputStream;
        import javax.sound.sampled.AudioSystem;
        import javax.sound.sampled.Clip;
        import javax.sound.sampled.DataLine;

        public class SoundUtils {
            public static double getLength(String path) throws Exception {
                AudioInputStream stream;
                stream = AudioSystem.getAudioInputStream(new URL(path));
                AudioFormat format = stream.getFormat();
                if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                    format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
                            .getSampleRate(), format.getSampleSizeInBits() * 2, format
                            .getChannels(), format.getFrameSize() * 2, format
                            .getFrameRate(), true); // big endian
                    stream = AudioSystem.getAudioInputStream(format, stream);
                }
                DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat(),
                        ((int) stream.getFrameLength() * format.getFrameSize()));
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.close();
                return clip.getBufferSize()
                        / (clip.getFormat().getFrameSize() * clip.getFormat()
                                .getFrameRate());
            }

            public static void main(String[] args) {
                try {

                    System.out
                            .println(getLength("..."));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }