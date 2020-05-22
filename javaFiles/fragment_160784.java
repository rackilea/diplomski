import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MouseInput {
    private JPanel mouse_pad = new JPanel();
    private JLabel label;

    private static int x;
    private static int y;

    public static void main(String[] args) {
        MouseInput instance = new MouseInput();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                instance.createUIComponents();
                instance.displayJframe();
            }
        });

    }
    public void displayJframe(){
        // Create blank content frame
        JFrame frame = new JFrame("Mouse Input");
        frame.add(mouse_pad, BorderLayout.CENTER);
        frame.add(label, BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Add mouse motion listener
        mouse_pad.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                label.setText("X = " + x + " , Y = " + y);
            }
        });

        // Set cursor type
        frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        // Display frame
        frame.setVisible(true);
    }

    private void createUIComponents() {
        label = new JLabel();
        label.setText("X = " + x + " , Y = " + y);
    }
}