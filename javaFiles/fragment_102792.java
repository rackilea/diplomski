private ActionListener createActionListener(final int y, final int x)
{
    return new ActionListener()
    {
        @Override 
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Clicked "+y+" "+x);

            // Some method that should be called in 
            // response to the button click:
            clickedButton(y,x);
        }
    };
}

private void clickedButton(int y, int x)
{
    // Do whatever has to be done now...
}