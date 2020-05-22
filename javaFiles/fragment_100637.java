import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui {
JFrame frame;
JButton button;
JCheckBox checkBox;
JLabel label;

public Gui() {
    frame = new JFrame("demo");
    button = new JButton("is it checked?");
    checkBox = new JCheckBox();
    label = new JLabel("no");
    JPanel panel = new JPanel();
    panel.add(checkBox);
    panel.add(button);
    panel.add(label);
    frame.add(panel);
    frame.pack();
    //frame.setSize(200, 60);
    frame.setResizable(false);
    frame.setLocation(400, 400);
    frame.setVisible(true);
}

// method to add an action listener to the gui's
// private button
public void setButtonActionListener(ActionListener al) {
    button.addActionListener(al);
}

// gui method to check if box is checked
public boolean isBoxChecked() {
    return checkBox.isSelected();
}

// method to set lable
public void setText(String text) {
    label.setText(text);
}

}