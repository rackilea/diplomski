import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class RandomButton {

    JButton[][] buttons = new JButton[10][10];
    JButton randomButton = new JButton("Choose Random Button");

    public RandomButton() {
        JPanel panel = new JPanel(new GridLayout(10, 10));
        initButtons(panel);

        randomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                while (true) {
                    int[] indices = getRandom();
                    int i = indices[0];
                    int j = indices[1];
                    if (!"X".equals(buttons[i][j].getText())) {
                        buttons[i][j].setForeground(Color.BLUE);
                        buttons[i][j].setText("X");
                        break;
                    }
                }
            }
        });

        randomButton.setBorder(new LineBorder(Color.black, 5));
        panel.setBorder(new LineBorder(Color.BLACK, 5));

        JFrame frame = new JFrame("Random Button");
        frame.add(panel);
        frame.pack();
        frame.add(randomButton, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public int[] getRandom() {
        Random rand = new Random();
        int i = rand.nextInt(10);
        int j = rand.nextInt(10);
        int[] indices = {i, j};
        return indices;
    }

    private void initButtons(JPanel panel) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton("O");
                panel.add(buttons[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RandomButton();
            }
        });
    }
}