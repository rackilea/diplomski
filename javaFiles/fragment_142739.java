import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InputTest extends JFrame {

    private final JTextArea textarea;
    private final JButton button;

    public InputTest(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textarea = new JTextArea(5,30);

        button = new JButton("new input");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(InputTest.this, "Please enter some text");

                if((input != null) && !input.isEmpty()) {
                    textarea.append(input);
                    textarea.append(System.getProperty("line.separator"));
                }                
            }
        });

        JPanel p = new JPanel(new BorderLayout());
        p.add(textarea, BorderLayout.NORTH);
        p.add(button, BorderLayout.SOUTH);


        this.getContentPane().add(p);

    }

    public static void main(String[] args) {
        InputTest it = new InputTest("Input Test");
        it.setSize(200, 200);
        it.setVisible(true);
    }

}