Timer timer = new Timer(1000, new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        currentTurn = computer;
        computerMove();
    }
});
timer.setRepeats(false);
timer.start();