import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToePanel extends JPanel {
    private static final int SIDES = 3;
    private static final Font FONT = new Font(Font.SANS_SERIF, Font.BOLD, 60);

    // 2D array of all buttons
    private JButton[][] grid = new JButton[SIDES][SIDES];

    public TicTacToePanel() {
        // use a single ActionListener for all buttons
        ButtonListener listener = new ButtonListener();

        // use a GridLayout to easily create your 3x3 grid
        setLayout(new GridLayout(SIDES, SIDES));

        // use a nested for loop to create your "grid" of
        // JButtons. 
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {

                // create your button, and its properties
                JButton btn = new JButton("   "); // give it some width
                btn.setFont(FONT); // make button bigger by using large Font

                // add an ActionListener to it
                btn.addActionListener(listener);

                // add it to the GUI -- the current JPanel
                add(btn);

                // place it in the 2D grid array of JButton
                grid[row][column] = btn;
            }
        }
    }

    // single listener for all buttons
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get which button was pushed
            JButton sourceButton = (JButton) e.getSource();

            // Now use nested for loops to find row and column button pressed

            // change text in that button if not already set

            // check for win here. Since you know the row and column of the 
            // last button pressed
            // you can search for win associated with the row, column, and possibly
            // diagonal that involves just that button. No need to look at all possible
            // wins.

        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TicTacToePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}