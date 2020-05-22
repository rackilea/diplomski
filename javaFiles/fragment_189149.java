public void createGui(String text, final Callback callback)
{
    [...]

    b.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            String modifiedText = // Manipulate the text
            // label.setText(modifiedText);

            callback.onChange(modifiedText);
        }
    });

    [...]
}

private interface Callback
{
    void onChange(String newValue);
}

public static void main(String[] args)
{
    createGui("InitialText", new Callback() 
    {
        @Override
        void onChange(String newValue)
        {
            // Do something with the string here.
        }
    });
}