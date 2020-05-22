public static void main(String[] args)
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton("Action");
    String[] commands = {"command1", "command2", "command3"};

    button.setActionCommand(commands[0]);
    button.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton btn = (JButton)e.getSource();

            String cmd = btn.getActionCommand();
            System.out.println("Command: " + cmd);

            if(cmd.equals("command1"))
            {
                btn.setActionCommand(commands[1]);
                System.out.println("Command 1 was pressed");
            }
            else if(cmd.equals("command2"))
            {
                btn.setActionCommand(commands[2]);
                System.out.println("Command 2 was pressed");
            }
            else if(cmd.equals("command3"))
            {
                btn.setActionCommand(commands[0]);
                System.out.println("Command 3 was pressed");
            }
            else
                System.out.println("Something went wrong!");
        }
    });
    panel.add(button);

    frame.add(panel);
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}