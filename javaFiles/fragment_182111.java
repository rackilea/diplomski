import javax.swing.*;
import java.awt.event.*;

public class TestForm {

private JButton button1;
private JPanel panel1;

public TestForm() {
    getButton1().addActionListener(new clickListener());
}

public JButton getButton1() {
    return button1;
}


public static void main(String[] args) {
    JFrame frame = new JFrame("TestForm");
    frame.setContentPane(new TestForm().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}

public void changeTextOnButton(){
    getButton1().setText("gwerz");
}

public class clickListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if (getButton1().getText().equals("Button")){
        getButton1().setText("Dgsdg");
    }
    else {
        getButton1().setText("Button");
    }
}
}


}