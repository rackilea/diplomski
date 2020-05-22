import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        panel.setBorder(new LineBorder(Color.BLACK, 5));

        JFrame frame = new JFrame("Random Button");
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            System.out.println(button.getText());
        }
    }


    private void initButtons(JPanel panel) {
        ButtonListener listener = new ButtonListener();
        int count = 1;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                JButton button = new JButton(String.valueOf(count));
                buttons[i][j] = button;
                button.addActionListener(listener);
                panel.add(button);
                count++;
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