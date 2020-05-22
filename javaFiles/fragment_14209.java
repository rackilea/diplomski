import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMethods extends MouseAdapter {

    private JLabel label = new JLabel("This is a JLabel");
    private JButton button = new JButton("This is a JButton");

    public MouseMethods() {
        JFrame frame = new JFrame("MouseMethods");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        label.addMouseListener(this);
        button.addMouseListener(this);
        frame.getContentPane().addMouseListener(this);

        frame.add(label);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(button)) {
            System.out.println("The JButton was clicked...");
        } else if (e.getSource().equals(label)) {
            System.out.println("The JLabel was clicked...");
        } else {
            System.out.println("Something else was clicked...");
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MouseMethods();
            }
        });
    }
}