import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Example {
    JFrame frame;
    JPanel panel;
    JTextField trextField1;
    JTextField trextField2;
    JTextField trextField3;
    JTextField trextField4;
    JButton button;
    public Example() {
        execute();
    }

    public void execute(){
        frame = new JFrame("GridBag");
        frame.setSize(400,400);

        trextField1 = new JTextField("Hello");
        trextField2 = new JTextField("Friend");
        trextField3 = new JTextField("How r u");
        trextField4 = new JTextField("");
        trextField4.setSize(50, 10);

        panel= new JPanel();

        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setSize(400,400);

        panel.add(trextField1);
        panel.add(trextField2);
        panel.add(trextField3);
        panel.add(trextField4);

        button = new JButton("Say it");
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);


        buttonAction();
    }

    public void buttonPress(){
        //If you have lot of textfields you need to get values to array and iterate through them
        String s = trextField1.getText() + trextField2.getText() + trextField3.getText();
        trextField4.setText(s);

    }

    public void buttonAction(){
        button.addActionListener(new ActionListener() { 
              public void actionPerformed(ActionEvent e) { 
                  buttonPress();
              }});
    }

    public static void main(String[] args){
        Example g = new Example();
    }
}