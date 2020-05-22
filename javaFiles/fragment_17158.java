import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyMouseListener extends MouseAdapter {

    private JButton btn;
    private String testString = "A String to be delivered to another class as a parameter";
    private MyFrame myFrame;

    public MyMouseListener(JButton btn, MyFrame myFrame) {
        this.btn = btn;
        this.myFrame = myFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        switch (btn.getText()) {
        // Deal with the pass logic here.
        case "Open":
            myFrame.passParamTest(testString);
            // Pass the String testString to Test class
            break;

        default:
            break;
        } 
    }
}