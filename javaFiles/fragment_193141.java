import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AwesomeGame {

    public static void main(String[] args) {
        new AwesomeGame();
    }

    public AwesomeGame() {
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
                frame.add(new ContentPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface NavigationController {
        public void letsPlay();
    }

    public class ContentPane extends JPanel implements NavigationController {

        private CardLayout cardLayout;
        private GamePane gamePane;

        public ContentPane() {
            cardLayout = new CardLayout();
            setLayout(cardLayout);
            add(new MenuPane(this), "TheMenu");
            add((gamePane = new GamePane()), "TheGame");
            cardLayout.show(this, "TheMenu");
        }

        @Override
        public void letsPlay() {
            cardLayout.show(this, "TheGame");
            gamePane.play();
        }

    }

    public class MenuPane extends JPanel {

        public MenuPane(NavigationController navigationController) {
            JLabel label = new JLabel("My Super Dupa Awesome Game!");
            label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            add(label, gbc);

            JButton play = new JButton("Play Now!");
            play.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    navigationController.letsPlay();
                }
            });
            add(play, gbc);

            setBackground(Color.GREEN);
        }

    }


    public class GamePane extends JPanel {

        public GamePane() {
            setBackground(Color.BLUE);
        }

        public void play() {
            Timer timer = new Timer(500, new ActionListener() {
                int count;
                @Override
                public void actionPerformed(ActionEvent e) {
                    count++;
                    if (count % 2 == 0) {
                        setForeground(Color.BLACK);
                    } else {
                        setForeground(Color.RED);
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            String text = "I bet you're blowen away by it's awesomness!";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g2d.drawString(text, x, y);
            g2d.dispose();
        }

    }
}