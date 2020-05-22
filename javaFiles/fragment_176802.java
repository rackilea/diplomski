import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquareGrid {

    private int rowCount;
    private int colCount;

    public SquareGrid(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;

    }
    JFrame theFrame;
    JButton[][] buttons;

    JPanel panel;

    private void createAndShowGui() {
        theFrame = new JFrame("grid");
        buttons = new JButton[rowCount][colCount];
        panel = new JPanel();
        panel.setLayout(new GridLayout(rowCount, colCount));

        for (int rowCounter = 0; rowCounter < rowCount; rowCounter++) {
            for (int colCounter = 0; colCounter < colCount; colCounter++) {
                final JButton j = new JButton("not clicked");
                j.setActionCommand((rowCounter + 1) * (colCounter + 1) + "");
                j.addActionListener(new ActionListener() {
                    boolean clicked = false;

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        if(clicked == false) clicked = true;
                        else clicked = false;

                        if (clicked) {
                            j.setText(j.getActionCommand());

                        } else {
                            j.setText("not clicked");
                        }

                    }
                });
                buttons[rowCounter][colCounter] = j;
                panel.add(j);
                JButton buttonClicked = (j);  //THIS WAS ADDED

            }
        }
        theFrame.add(panel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.pack();
        theFrame.setVisible(true);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rowCount = input.nextInt();

        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter number of columns");
        int colCount = input1.nextInt();

        SquareGrid h = new SquareGrid(colCount, rowCount);
        h.createAndShowGui();
    }
}