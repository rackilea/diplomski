Text text = new Text(shell, SWT.BORDER);
text.addListener(SWT.Verify, new Listener()
{
    @Override
    public void handleEvent(Event e)
    {
        // Get the source widget
        Text source = (Text) e.widget;

        // Get the text
        final String oldS = source.getText();
        final String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

        System.out.println(oldS + " -> " + newS);
    }
});