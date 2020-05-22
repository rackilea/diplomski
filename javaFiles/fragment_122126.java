int counter = 0;

button.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        counter++;

        if(counter == 10)
        {
            button.setEnabled(false);

            // Show message dialog
            JOptionPane.showMessageDialog(null, "This is my message", "This is my message title", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}