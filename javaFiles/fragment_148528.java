import java.awt.EventQueue;
import javax.swing.JFrame;

public class CreateJFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame1 = new JFrame();
                    setJframe("Title of the first Frame", 500, 800, frame1, false);
                    frame1.setVisible(true);

                    JFrame frame2 = new JFrame();
                    setJframe("Title of the second Frame", 100, 200, frame2, false);
                    frame2.setVisible(true);

                    JFrame frame3 = new JFrame();
                    setJframe("Title of the third Frame", 100, 200, frame3, true);
                    frame3.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void setJframe(String title, int w, int h, JFrame name, Boolean maximize) {
        name.setSize(w, h);
        name.setTitle(title);

        if (maximize == true) {
            name.setExtendedState(name.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        } else {
            name.setLocationRelativeTo(null);
        }
    }
}