JTextArea input = new JTextArea();
input .getDocument().addDocumentListener(new DocumentListener() {

    @Override
    public void removeUpdate(DocumentEvent e) {}

    @Override
    public void insertUpdate(DocumentEvent e) {}

    @Override
    public void changedUpdate(DocumentEvent arg0) {
            //Add logic here to check if particular word is entered.
            //if yes show label, else hide the label object 
    }
});