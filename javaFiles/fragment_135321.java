action = new AbstractAction()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        labelToChange.setText("" + timerCounter);
        timerCounter++;

        if (timerCounter > 5)
        {
            Timer timer = (Timer)e.getSource();
            timer.stop();
        }
    }
}