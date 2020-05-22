final String[] textHolder = { null };

EventQueue.invokeAndWait(new Runnable() {
    @Override
    public void run() {
        textHolder[0] = someTextField.getText();
    }
});

String text = textHolder[0];