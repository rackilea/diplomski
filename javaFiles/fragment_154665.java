this.textArea.addKeyUpHandler(new KeyUpHandler()
{
    public void onKeyUp(final KeyUpEvent event)
    {
        outer.validate();
    }
});