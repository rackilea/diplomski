import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderGUI {

    public static void main(String[] args) {
        new SliderGUI();
    }

    public SliderGUI() {
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

        public JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
        public JLabel label;
        public int delay;
        public int speed;
        public ImageIcon imageIcon;
        public Timer timer;

        public TestPane() {
            setLayout(new GridLayout(5, 5, 5, 25));
            slider.setPaintLabels(true);

            label = new JLabel();
            try {
                BufferedImage frameImage = ImageIO.read(getClass().getResource("/Run-0.png"));
                label.setIcon(new ImageIcon(frameImage));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            SliderListener sliderListener = new SliderListener();
            timer = new Timer(delay, sliderListener);
            slider.addChangeListener(sliderListener);
            System.out.println(speed);
            timer.addActionListener(sliderListener);

            timer.start();

            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

            add(label);
            add(slider);
        }

        private class SliderListener implements ChangeListener, ActionListener {

            public void stateChanged(ChangeEvent e) {

                int value = slider.getValue();
                timer.setDelay(value);

            }

            private int frame = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tick " + ((Timer) e.getSource()).getDelay());
                try {
                    BufferedImage frameImage = ImageIO.read(getClass().getResource("/Run-" + frame + ".png"));
                    label.setIcon(new ImageIcon(frameImage));
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
                frame++;
                if (frame > 11) {
                    frame = 0;
                }
            }
        }

    }

}