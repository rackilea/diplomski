import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CursorTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private javax.swing.Timer timer = null;
    private JScrollPane scroll;

    public CursorTest() {
        scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(400,300));
        setTitle("CursorTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(scroll);
        setLocation(100, 100);
        pack();
        setVisible(true);
        start();
    }

    private void start() {
        scroll.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        timer = new javax.swing.Timer(5000, stop());
        timer.start();
    }

    public Action stop() {
        return new AbstractAction("Change Cursor Action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                scroll.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        };
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CursorTest().setVisible(true);
            }
        });
    }
}