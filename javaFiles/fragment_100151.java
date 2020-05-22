javax.swing.Timer timer = new javax.swing.Timer(WAIT_TIME * 1000, new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        if (stage != STAGE_TWO) {
            stage = WELCOME;
            setScreen(stage);
        }
    }
});
timer.start();