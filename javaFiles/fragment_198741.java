protected void textChanged( String changedText ) {
    // Collect all changes here
}

JTextField textField = new MyTextField( text -> textChanged( text ) );

private class MyTextField extends JTextField {
    private final Consumer<String> textChangedConsumer;

    public MyTextField( Consumer<String> textChangedConsumer ) {
        super();
        this.textChangedConsumer = textChangedConsumer;

        getDocument().addDocumentListener( new DocumentListener() {

            @Override
            public void removeUpdate( DocumentEvent e ) {
                textChangedConsumer.accept( getText() );
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                textChangedConsumer.accept( getText() );
            }

            @Override
            public void changedUpdate( DocumentEvent e ) {
                textChangedConsumer.accept( getText() );
            }
        } );
    }
}