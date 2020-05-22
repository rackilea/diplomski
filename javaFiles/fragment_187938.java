import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class TestFrame2 {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                createAndShow();
            }
        });
    }

    public static void createAndShow() {
        JFrame frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyTestPanel panel = new MyTestPanel();

        //add any other components like buttons, labels to panel

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        panel.setParentPane(scrollPane);
        scrollPane.setPreferredSize(new Dimension(700, 300));
        frame.add(scrollPane);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                //panel.stopCursorThread();
            }
        });
        //frame.setSize(300, 300);
        frame.pack();
        //frame.setSize(frame.getWidth(), frame.getHeight());
        frame.setLocationRelativeTo(null);
        System.out.println(frame.getWidth() + " : " + frame.getHeight());
        frame.setVisible(true);
        //panel.startCursorThread();
    }
}