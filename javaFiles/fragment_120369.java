import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class TTTButtons {

    ImageIcon oooIcon;
    MyButton[][] buttons = new MyButton[3][3];
    JPanel gamePanel;

    public TTTButtons() {
        oooIcon = new ImageIcon(getClass().getResource("/resources/ooooo.png"));
        gamePanel = createGamePanel();

        JFrame frame = new JFrame("TicTacToe");
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private JPanel createGamePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new MyButton(oooIcon);
                panel.add(buttons[i][j]);
            }
        }
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TTTButtons();
            }
        });
    }

    public class MyButton extends JButton {

        Image oooImage;
        boolean leftRight = false;
        boolean clicked = false;
        boolean ooo = false;

        boolean tictactoe = false;

        public MyButton(ImageIcon oooImage) {
            this.oooImage = oooImage.getImage();
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clicked = true;
                    ooo = true;
                    if (buttons[0][0].clicked && buttons[0][1].clicked && buttons[0][2].clicked) {
                        for (int i = 0; i < 3; i++) {
                            buttons[0][i].leftRight = true;
                            buttons[0][i].tictactoe = true;
                            buttons[0][i].repaint();
                        } 
                        return;
                    }
                    repaint();
                }
            });
            setBorder(new LineBorder(Color.BLACK, 1));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (clicked) {
                if (ooo) {
                    g.drawImage(oooImage, 0, 0, getWidth(), getHeight(), this);
                }
            } else {
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
            if (tictactoe) {
                if (leftRight) {
                    g.drawLine(0, (int) (getHeight() / 2), getWidth(), (int) (getHeight() / 2));
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return oooImage == null ? new Dimension(100, 100)
                    : new Dimension(oooImage.getWidth(this), oooImage.getHeight(this));
        }
    }
}