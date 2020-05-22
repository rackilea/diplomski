import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JComponent chart = new Board("1");

                frame.setSize(600, 600);
                frame.setTitle("SleutelBarricade");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.add(chart);
                frame.setVisible(true); 
            }
        });
    }
}