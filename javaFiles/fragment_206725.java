import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        private int recHeight = 0;
        private int recWidth = 0;

        //Here Buttons
        JButton heightIncrease = new JButton("+");
        JButton heightDecrease = new JButton("-");

        JLabel height = new JLabel(Integer.toString(recHeight));
        JLabel width = new JLabel(Integer.toString(recWidth));

        GridLayout gridLayout = new GridLayout(2, 4);

        public TestPane() {
            setLayout(new BorderLayout());
            //Create GridPanel and set Layout
            JPanel grid = new JPanel();
            grid.setLayout(gridLayout);

            grid.add(height);
            grid.add(width);

            //Create buttondrawPanel and set Layout
            JPanel buttondraw = new JPanel();
            buttondraw.setLayout(new GridLayout(2, 0));

            heightIncrease.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    recHeight += 1;
                    height.setText(Integer.toString(recHeight));
                }
            });
            heightDecrease.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    recHeight -= 1;
                    height.setText(Integer.toString(recHeight));
                }
            });

            buttondraw.add(heightIncrease);
            buttondraw.add(heightDecrease);

            //Adding Components to GridPanel
            //Adding Layouts to pane
            add(grid, BorderLayout.NORTH);
            add(new JSeparator(), BorderLayout.CENTER);
            add(buttondraw, BorderLayout.SOUTH);
        }

    }
}