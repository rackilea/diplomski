import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestRecord {

    public static void main(String[] args) {
        new TestRecord();
    }

    public TestRecord() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        private JToggleButton recordButton;

        protected static final AudioFileFormat.Type FILE_TYPE = AudioFileFormat.Type.WAVE;
        private TargetDataLine line;

        public TestPane() {
            setLayout(new GridBagLayout());
            recordButton = new JToggleButton("Record");
            recordButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (recordButton.isSelected()) {
                        startRecording();
                        recordButton.setText("Stop");
                    } else {
                        stopRecording();
                        recordButton.setText("Record");
                    }
                }
            });
            add(recordButton);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void stopRecording() {

            if (line != null) {

                line.stop();
                line.close();
                line = null;

            }

        }

        protected void startRecording() {
            if (line == null) {
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            AudioFormat format = getAudioFormat();
                            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

                            // checks if system supports the data line
                            if (!AudioSystem.isLineSupported(info)) {
                                System.out.println("Line not supported");
                                System.exit(0);
                            }
                            line = (TargetDataLine) AudioSystem.getLine(info);
                            line.open(format);
                            line.start();   // start capturing

                            System.out.println("In utils.Recorder: Start capturing...");

                            AudioInputStream ais = new AudioInputStream(line);

                            System.out.println("In utils.Recorder: Start recording...");

                            // start recording
                            System.out.println("Is recoding");
                            AudioSystem.write(ais, FILE_TYPE, new File("Test.wav"));

                        } catch (LineUnavailableException ex) {
                            ex.printStackTrace();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }

                        System.out.println("Recording is done");
                    }
                });
                t.start();
            }
        }

        protected AudioFormat getAudioFormat() {
            float sampleRate = 16000;
            int sampleSizeInBits = 8;
            int channels = 2;
            boolean signed = true;
            boolean bigEndian = true;
            AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                            channels, signed, bigEndian);
            return format;
        }
    }

}