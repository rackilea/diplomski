import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIMultiplicationTable
{
    JFrame theFrame;
    int number = 0;
    JPanel panel;

    private void createAndShowGui()
    {
        String x;
        do
        {
            x = JOptionPane.showInputDialog(null, "Enter the number");
            number = Integer.parseInt(x);
        } while (number <= 0);
        theFrame = new JFrame("Multiplication Table");
        panel = new JPanel(new GridLayout(number, number));
        for (int i = 0; i < number; i++)
        {
            for (int j = 0; j < number; j++)
            {
                JButton button = new JButton();
                if (i == 0)
                {
                    button.setText(String.valueOf(j + 1));
                }
                if (j == 0)
                {
                    button.setText(String.valueOf(i + 1));
                }
                for (int k = 1; k < number; k++)
                {
                    if (i == k)
                    {
                        button.setText(String.valueOf((j + 1) * (k + 1)));
                    }
                }
                button.addActionListener(new ButtonsTableActionListener(i, j));
                panel.add(button);
            }
        }
        theFrame.add(panel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.pack();
        theFrame.setLocationRelativeTo(null);
        theFrame.setVisible(true);

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                GUIMultiplicationTable h = new GUIMultiplicationTable();
                h.createAndShowGui();
            }
        });

    }

    private class ButtonsTableActionListener implements ActionListener
    {
        private int _row, _column;

        public ButtonsTableActionListener(int row, int column)
        {
            _row = row;
            _column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // /do something
            int value = (_row + 1) * (_column + 1);
            String message = "I'm the button in the position (" + _row + ", " + _column + ")\nMy value is " + value + " = " + (_row + 1) + "*" + (_column + 1);
            JOptionPane.showMessageDialog(theFrame, message);
        }
    };
}