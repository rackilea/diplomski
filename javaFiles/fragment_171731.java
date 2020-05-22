import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonExample1 extends JPanel {

    private JButton makeButton (String name) {
        final JButton button =new JButton(name);
        add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button.setText("I was clicked");
            }
        });

        return button;
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.add(makeButton("One"));
        contentPane.add(makeButton("Two"));
        contentPane.add(makeButton("Three"));       

        frame.setContentPane(contentPane);  
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new ButtonExample1().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}