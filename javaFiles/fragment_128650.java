import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MyFrame() {
        final JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout(10, 10));
        JButton myButton = new JButton("Add Component ");
        myButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JPanel childPanel1 = new JPanel();
                childPanel1.setBackground(Color.red);
                childPanel1.setPreferredSize(new Dimension(300, 40));
                JPanel childPanel2 = new JPanel();
                childPanel2.setBackground(Color.blue);
                childPanel2.setPreferredSize(new Dimension(800, 600));

                parentPanel.add(childPanel1, BorderLayout.NORTH);
                parentPanel.add(childPanel2, BorderLayout.CENTER);

                parentPanel.revalidate();
                parentPanel.repaint();

                pack();
            }
        });
        setTitle("My Empty Frame");
        setLocation(10, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parentPanel.add(myButton, BorderLayout.SOUTH);
        add(parentPanel);
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