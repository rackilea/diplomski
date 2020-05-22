import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

public class KaraokeTest {

    private int[] timings = {2000, 1000, 4000, 2000, 3000};//char timings
    private String[] words = {"H", "e", "l", "l", "o"};//each indiviaul word
    private String sentence = "Hello";//entire string for writing to JSCrollPane
    private DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
    private int count = 0;
    private boolean fisrTime = true;
    private JFrame frame;
    private JTextPane jtp;
    JButton startButton;

    public KaraokeTest() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        jtp = new JTextPane();

        jtp.setText(sentence);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                startKaraoke();
            }
        });

        frame.add(jtp, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void startKaraoke() {
        if (fisrTime) {
            startButton.setEnabled(false);
            fisrTime = false;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                Timer t = createAndStartTimer(timings[count], count);

                while (t.isRunning()) {//wait for timer to be done
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        count++;
                        if (count == timings.length) {
                            JOptionPane.showMessageDialog(frame, "Done");
                            startButton.setEnabled(true);
                            count = 0;
                            fisrTime = true;
                        } else {
                            startKaraoke();
                        }
                    }
                });

            }
        }).start();
    }

    private Timer createAndStartTimer(int delay, final int count) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int sp = 0;
                for (int i = 0; i < count; i++) {
                    sp += words[i].length();
                }
                try {
                    jtp.getHighlighter().addHighlight(sp, sp + words[count].length(), highlightPainter);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Timer t = new Timer(delay, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.getHighlighter().removeAllHighlights();
            }
        });
        t.setRepeats(false);
        t.start();
        return t;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KaraokeTest();
            }
        });
    }
}