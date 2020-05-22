import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MyPanel extends JPanel{

    public MyPanel() {
        setLayout(new GridLayout(5, 5, 25, 25));
        for (int i = 0; i < 25; i++) {
            add(new JButton(" "));
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new MyPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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