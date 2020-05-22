import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JavaApplication155 {

    public static void main(String[] args) {
        new JavaApplication155();
    }

    public JavaApplication155() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() throws IOException {
            JButton btn = new JButton();
            BufferedImage cat = ImageIO.read(getClass().getResource("cat.png"));
            BufferedImage dog = ImageIO.read(getClass().getResource("dog.png"));

            btn.setIcon(new ImageIcon(cat));
            btn.setRolloverEnabled(true);

            RolloverAnimator animator = new RolloverAnimator(btn, cat, dog);

            setLayout(new GridBagLayout());
            add(btn);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class RolloverAnimator {

        private JButton btn;
        private BufferedImage normalImage;
        private BufferedImage rolloverImage;

        private double progress;

        private Timer timer;

        private int totalAnimationTime = 300;
        private int animationTime = totalAnimationTime;
        private Long startedAt = null;

        private boolean wasRolledOver = false;

        public RolloverAnimator(JButton btn, BufferedImage normalImage, BufferedImage rolloverImage) {
            this.btn = btn;
            this.normalImage = normalImage;
            this.rolloverImage = rolloverImage;
            ButtonModel model = btn.getModel();
            model.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (model.isArmed()) {
                        return;
                    }
                    if (model.isRollover() && !wasRolledOver) {
                        wasRolledOver = true;
                        prepare();
                    } else if (!model.isRollover() && wasRolledOver) {
                        wasRolledOver = false;
                        prepare();
                    }
                }
            });

            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startedAt == null) {
                        startedAt = System.currentTimeMillis();
                    }
                    long duration = System.currentTimeMillis() - startedAt;
                    progress = (double) duration / (double) animationTime;
                    if (progress > 1.0) {
                        progress = 1.0;
                        startedAt = null;
                        timer.stop();
                    }
                    BufferedImage target = transition(normalImage, rolloverImage, progress);
                    btn.setIcon(new ImageIcon(target));

                    if (!timer.isRunning()) {
                        progress = 0.0;
                    }
                }
            });
        }

        protected void prepare() {
            if (timer.isRunning()) {
                timer.stop();
                animationTime = (int) ((double) totalAnimationTime * progress);
                startedAt = System.currentTimeMillis() - (totalAnimationTime - (long)animationTime);
            } else {
                animationTime = totalAnimationTime;
                startedAt = null;
            }
            progress = 0.0;

            timer.start();
        }

        public BufferedImage transition(BufferedImage from, BufferedImage to, double progress) {
            int width = Math.max(from.getWidth(), to.getWidth());
            int height = Math.max(from.getHeight(), to.getHeight());
            BufferedImage target = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = target.createGraphics();

            float normalAlpha = wasRolledOver ? 1.0f - (float) progress : (float) progress;
            float rollOverAlpha = wasRolledOver ? (float) progress : 1.0f - (float) progress;

            g2d.setComposite(AlphaComposite.SrcOver.derive(normalAlpha));
            draw(from, target, g2d);
            g2d.setComposite(AlphaComposite.SrcOver.derive(rollOverAlpha));
            draw(to, target, g2d);
            g2d.dispose();
            return target;
        }

        protected void draw(BufferedImage img, BufferedImage on, Graphics2D g2d) {
            int xPos = (img.getWidth() - on.getWidth()) / 2;
            int yPos = (img.getHeight() - on.getHeight()) / 2;
            g2d.drawImage(img, xPos, yPos, btn);
        }
    }

}