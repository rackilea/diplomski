import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Flashy {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BlinkPane());
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

    protected static class BlinkPane extends JLabel {

        private JLabel label;
        private boolean on = true;

        public BlinkPane() {
            label = new JLabel("Hello");
            setLayout(new GridBagLayout());

            add(label);
            Timer timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    on = !on;
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            if (!on) {
                g2d.setComposite(AlphaComposite.SrcOver.derive(0f));
            } else {
                g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
            }
            super.paint(g2d); 
            g2d.dispose();
        }

    }
}