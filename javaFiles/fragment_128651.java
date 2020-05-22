import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel childPanel1 = new JPanel();
    private JPanel childPanel2 = new JPanel();
    private JPanel childPanel3 = new JPanel();

    public MyFrame() {
        childPanel1.setBackground(Color.red);
        childPanel1.setPreferredSize(new Dimension(300, 40));
        childPanel2.setBackground(Color.blue);
        childPanel2.setPreferredSize(new Dimension(300, 40));
        childPanel3.setBackground(Color.yellow);
        childPanel3.setPreferredSize(new Dimension(300, 40));

        JButton myButton = new JButton("Add Component ");
        myButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                add(childPanel2, BorderLayout.CENTER);
                pack();
            }
        });

        setTitle("My Empty Frame");
        setLocation(10, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(childPanel3, BorderLayout.CENTER);
        add(myButton, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyFrame myFrame = new MyFrame();
            }
        });
    }
}