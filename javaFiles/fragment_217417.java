public static JTextField txt1;
final JButton submit;

public MainWindw()
{
    JFrame panel = new JFrame();
    txt1 = new JTextField();
    submit = new JButton("Submit");
    panel.setLayout(new FlowLayout());
    panel.add(txt1);
    panel.add(submit);
    submit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Submit button pressed" + txt1.getText());
        }
    });
    panel.setSize(300, 300);
    panel.setVisible(true);
}