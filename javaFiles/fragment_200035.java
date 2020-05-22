import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test{

    public static void main(String[] args) {
        new JavaApplication834();
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
                frame.add(new ContentPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ContentPane extends JPanel {

        private ButtonPane[][] buttonPanels;

        public ContentPane() {
            setLayout(new GridLayout(3, 3));
            buttonPanels = new ButtonPane[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttonPanels[row][col] = new ButtonPane();
                    add(buttonPanels[row][col]);
                }
            }
        }

        public ButtonPane getButtonPaneAt(int row, int col) {
            return buttonPanels[row][col];
        }

    }

    public class ButtonPane extends JPanel {

        private JButton[][] btns;

        public ButtonPane() {
            setLayout(new GridLayout(3, 3));
            btns = new JButton[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    btns[row][col] = new JButton(row + "x" + col);
                    add(btns[row][col]);
                }
            }
        }

        public JButton getButtonAt(int row, int col) {
            return btns[row][col];
        }

    }

}