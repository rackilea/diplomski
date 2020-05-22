import java.awt.*;

   class homework{
    public static void main(String[] args) {
        JFrame frame= new JFrame("border layout");
        frame.setVisible(true);
        JLabel label=new JLabel("Container of BorderLayout");
        JButton button3 = new JButton("EAST");
        JButton button5 = new JButton("CENTER");
        JButton button4 = new JButton("WEST");
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();

        frame.getContentPane().add(panel2);
        label.setLayout(new FlowLayout(0));
        panel2.add(label);
        panel1.setLayout(new BorderLayout());
        panel1.add(button3,BorderLayout.EAST);
        panel1.add(button4,BorderLayout.WEST);
        panel1.add(button5,BorderLayout.CENTER);
        frame.getContentPane().add(panel1);

        JPanel panel = new JPanel();
        panel1.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("New label");
        panel.add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
        panel.add(rdbtnNewRadioButton);

        JPanel panel_1 = new JPanel();
        panel1.add(panel_1, BorderLayout.SOUTH);

        JLabel lblNewLabel_1 = new JLabel("New label");
        panel_1.add(lblNewLabel_1);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
        panel_1.add(rdbtnNewRadioButton_1);

        frame.pack();

    }
 }