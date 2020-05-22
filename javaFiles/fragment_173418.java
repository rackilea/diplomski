public class Test
{
    JFrame myMainWindow = new JFrame("This is my title");
    JPanel  firstPanel = new JPanel(null);
    JTextField textfield1 = new JTextField();
    JButton button1 = new JButton("Check Company");

    public void runGUI() {
        myMainWindow.setBounds(10, 10, 500, 500);
        myMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myMainWindow.setLayout(new GridLayout(1,1));
        createFirstPanel();
        myMainWindow.getContentPane().add(firstPanel);
        myMainWindow.setVisible(true);
    }

    public void createFirstPanel() {
        textfield1.setBounds(335,102,90,35);
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEnabled(true);
        textfield1.setFont(new Font("sansserif",0,12));
        textfield1.setVisible(true);
        firstPanel.add(textfield1);

        button1.setBounds(335,150,150,35);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new Class2(textfield1.getText());
            }
        });
        firstPanel.add(button1);
    }

    public static void main(String[] args)
    {
        Test t = new Test();
        t.runGUI();
    }
}