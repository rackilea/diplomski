import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

public class JavaApplication5 {

    public static void main(String[] args) {
        new JavaApplication5();
    }

    public JavaApplication5() {
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

    public class TestPane extends JPanel {

        private Clip clip = null;

        private JTextField audioFile;
        private JButton browse;
        private JSpinner loops;
        private JSpinner delay;
        private JFileChooser chooser;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("Audio File:"), gbc);

            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            audioFile = new JTextField(20);
            add(audioFile);

            gbc.gridwidth = 1;
            gbc.weightx = 0;
            gbc.gridx++;
            browse = new JButton("...");
            add(browse, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Loops: "), gbc);

            loops = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
            gbc.gridx++;
            gbc.fill = GridBagConstraints.NONE;
            add(loops, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Delay (seconds): "), gbc);

            delay = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            gbc.gridx++;
            gbc.fill = GridBagConstraints.NONE;
            add(delay, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JButton play = new JButton("Play");
            add(play, gbc);

            play.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        play(
                                        audioFile.getText(),
                                        (int) delay.getValue(),
                                        (int) loops.getValue());
                    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                        ex.printStackTrace();;
                        JOptionPane.showMessageDialog(TestPane.this, "<html>Failed to play audio file:</br>" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            browse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chooser == null) {
                        chooser = new JFileChooser();
                        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        chooser.setMultiSelectionEnabled(false);
                        chooser.addChoosableFileFilter(new FileFilter() {
                            @Override
                            public boolean accept(File f) {
                                System.out.println(f);
                                return f.getName().toLowerCase().endsWith(".wav");
                            }

                            @Override
                            public String getDescription() {
                                return "Wave Files (.wav)";
                            }
                        });
                    }

                    if (chooser.showOpenDialog(TestPane.this) == JFileChooser.APPROVE_OPTION) {
                        File selected = chooser.getSelectedFile();
                        audioFile.setText(selected.getPath());
                    }
                }
            });

        }

        public void play(String path, int delay, int numberOfLoops) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
            if (clip != null) {
                clip.stop();
                clip = null;
            }

            if (delay > 0) {
                System.out.println("Start with delay");
                Timer timer = new Timer(delay * 1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            play(path, numberOfLoops);
                        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                            ex.printStackTrace();;
                            JOptionPane.showMessageDialog(TestPane.this, "<html>Failed to play audio file:</br>" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                play(path, numberOfLoops);
            }
        }

        private void play(String path, int numberOfLoops) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            File file = new File(path);
            if (file.exists()) {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.start();
            }
        }
    }

}