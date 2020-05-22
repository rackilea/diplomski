public void createGui(String text, Callback callback)
{
    [...]

    b.addListener(SWT.Selection, (e) -> {
        String modifiedText = // Manipulate the text
        label.setText(modifiedText);

        callback.onChange(modifiedText);
    });

    [...]
}

private static interface Callback
{
    void onChange(String newValue); 
}

public static void main(String[] args)
{
    createGui("InitialText", (s) -> {
        // Do something with the string here.
    });
}