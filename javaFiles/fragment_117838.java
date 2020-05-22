public class Client
{
    private JFrame frame;
    private JTextArea allMessagesArea;
    private JTextArea inputArea;
    private JButton buttonSend;
    private JButton buttonExit;
    private String login;

    public  void addComponentsToPanel2()
    {               
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.HORIZONTAL;

        allMessagesArea = new JTextArea(25,50);
        c.weighty = 0.6;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=2;
        panel2.add(allMessagesArea, c);


        inputArea = new JTextArea(12,50);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth=2;
        c.weighty =0.3;
        c.gridx =0;
        c.gridy =1;
        panel2.add(inputArea, c);

        buttonSend = new JButton("Send");
        c.weightx=0.5;
        c.weighty = 0.1;
        c.fill =  GridBagConstraints.HORIZONTAL;
        c.gridx =0;
        c.gridy=2;
        c.gridwidth =1;
        panel2.add(buttonSend, c);


        buttonExit = new JButton("Exit");
        c.weightx =0.5;
        c.weighty = 0.1;
        c.fill =  GridBagConstraints.HORIZONTAL;
        c.gridx =1;
        c.gridy=2;
        c.gridwidth =1;
        panel2.add(buttonExit, c);   
    }


    public Client()
    {
        frame = new JFrame("Simple Client");

        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcomePage();

        frame.setVisible(true);
    }

    public void welcomePage()
    {
        panel1 = new JPanel();
        JLabel label = new JLabel("Your login:");
        panel1.add(label);

        JTextField textField = new JTextField(15);
        panel1.add(textField);

        JButton loginButton = new JButton("log in");
        panel1.add(loginButton);

        JButton exitButton = new JButton("exit");
        panel1.add(exitButton);
        frame.add(panel1, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(textField.getText().isEmpty())
                    JOptionPane.showMessageDialog(frame.getContentPane(), "Please enter your login");
                else
                {
                    login = textField.getText();
                    System.out.println(login);

                    panel2 = new JPanel();
                    addComponentsToPanel2();
                    frame.remove(panel1);
                    frame.add(panel2);
                    //frame.repaint();
                    frame.pack();
                }
            }
        });

        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args)
    {

        Client frame = new Client();
    }

    private JPanel panel1;
    private JPanel panel2;
}