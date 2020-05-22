import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        public TestPane() {

            File c7 = new File("res/res39191__jobro__piano-ff-044.wav");
            File d7 = new File("res/39194__jobro__piano-ff-046.wav");

            add(new JLabel("Hello"));

            AbstractAction keyBindingReactorC7 = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playsound(c7);
                }
            };
            AbstractAction keyBindingReactorD7 = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playsound(d7);
                }
            };
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("C"),
                                                                                                                             "cPressed");
            getActionMap().put("cPressed", keyBindingReactorC7);

            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"),
                                                                                                                             "dPressed");
            getActionMap().put("dPressed", keyBindingReactorD7);
        }

        private Set<File> playing = new HashSet<File>(25);

        public void playsound(File sound) {
            try {
                if (!playing.contains(sound)) {
                    playing.add(sound);
                    Clip clip = AudioSystem.getClip();
                    clip.addLineListener(new LineListener() {
                        @Override
                        public void update(LineEvent event) {
                            if (event.getType() == LineEvent.Type.STOP) {
                                clip.close();
                                playing.remove(sound);
                            }
                        }
                    });
                    clip.open(AudioSystem.getAudioInputStream(sound));
                    clip.start();
                }
            } catch (Exception e) {
                playing.remove(sound);
                e.printStackTrace();
            }

        }
    }
}