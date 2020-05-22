public class Test
{
    public static void main(String[] args)
    {
        final JButton option1 = new JButton("option1");
        final JButton option2 = new JButton("option2");
        option1.setEnabled(false);
        // option2.setEnabled(false);
        option1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // code here
            }
        });
        option2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // code here
            }
        });
        JOptionPane.showOptionDialog(null, "hello", "The Title", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new JButton[]
        { option1, option2 }, option1);
    }
}