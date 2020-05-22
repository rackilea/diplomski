Button jumpTo = new Button(shell, SWT.PUSH);
jumpTo.setText("Jump to item");
jumpTo.addListener(SWT.Selection, new Listener()
{
    private int counter = 0;
    @Override
    public void handleEvent(Event e)
    {
        int y = getYPosition(bar, counter);

        /* Increment the counter */
        counter = (counter + 1) % bar.getItemCount();

        /* Scroll into view */
        scrolledComp.setOrigin(0, y);
    }
});