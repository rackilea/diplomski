field = new JFormattedTextField();
field.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        Runnable format = new Runnable() {
            @Override
            public void run() {
                String text = field.getText();
                if(!text.matches("\\d*(\\.\\d{0,2})?")){
                    field.setText(text.substring(0,text.length()-1));
                }
            }
        };
        SwingUtilities.invokeLater(format);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
});