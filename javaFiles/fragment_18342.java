import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class Main {
    JFrame frame = new JFrame();
    JTabbedPane tabbedPane = new JTabbedPane();
    FirstPanel fp = new FirstPanel();
    SecondPanel sp = new SecondPanel();

    public Main() {
        tabbedPane.add("First", fp);
        tabbedPane.add("Second", sp);
        frame.getContentPane().add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        // frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

}