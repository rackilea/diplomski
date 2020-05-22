Frame1.java
public class Frame1 extends JFrame{

    protected static Frame2 frame2;

    protected JTextField textField = new JTextField();
    protected JButton button = new JButton("Button");

    public Frame1() {

        JFrame Frame1 = new JFrame();
        Frame1.setBounds(0, 0, 200, 100);
        Frame1.setVisible(true);

        Frame1.add(textField, BorderLayout.NORTH);
        Frame1.add(button, BorderLayout.CENTER);

        button.addActionListener(
                newButtonListener(
                textField,frame2.textField));
    }


    public static void main(String[] args) {
        frame2 = new Frame2();
        new Frame1();       
    }
}

Frame2.java
public class Frame2 {

    protected JTextField textField = new JTextField();

    public Frame2() {

        JFrame Frame1 = new JFrame();
        Frame1.setBounds(200, 0, 200, 100);
        Frame1.setVisible(true);

        Frame1.add(textField, BorderLayout.CENTER);     
    }
}

ButtonListener.java
public class ButtonListener implements ActionListener{

    protected JTextField textField;
    protected JTextField textField2;

    public ButtonListener(JTextField textField, JTextField textField2) {
        this.textField = textField;
        this.textField2 = textField2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Button")) {
            System.out.println(textField.getText());
            textField2.setText(textField.getText());
        }   
    }   
}