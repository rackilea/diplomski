b1.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        input1 = jt1.getText();
        f1.dispose();
        //f1.setVisible(false); // or dispose if you no longer need it
        f2.setVisible(true);
    }
});