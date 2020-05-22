import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            JButton btn = new JButton("Switch");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Window window = SwingUtilities.getWindowAncestor(TestPane.this);
                    if (!(window instanceof JFrame)) {
                        System.out.println("Not out frame");
                        return;
                    }
                    JFrame frame = (JFrame) window;
                    FadePane pane = new FadePane();
                    pane.setLayout(new BorderLayout());
                    pane.add(new JLabel("All your base are belong to us"));
                    pane.setFaddedOut();
                    pane.addFadeListener(new FaderListener() {
                        @Override
                        public void fadeDidComplete(FadePane pane) {
                            System.out.println("Completed");
                            if (pane.getAlpha() == 1) {
                                System.out.println("Fade out");
                                pane.fadeOut();
                            } else {
                                System.out.println("Remove glasspane");
                                frame.setGlassPane(new JPanel());
                            }
                        }
                    });
                    frame.setGlassPane(pane);
                    System.out.println("Fade in");
                    pane.setVisible(true);
                    pane.fadeIn();
                }
            });
            add(btn);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}