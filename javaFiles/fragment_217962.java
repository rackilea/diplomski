javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        showDisplay();
    }
});
timer.setRepeats(true);
timer.start();