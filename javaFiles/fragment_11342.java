import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private boolean booleanToChange = false;

    private JButton exampleButton;

    public MyFrame() {
        exampleButton = new JButton();
        exampleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Access a member in anonymous class
                MyFrame.this.booleanToChange = true;
            }
        });
    }
}