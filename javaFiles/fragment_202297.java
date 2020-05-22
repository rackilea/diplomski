nbMuscle = new JTextField();
nbMuscle.setText("2");
nbFuyard = new JTextField();
nbFuyard.setText("1");

nbPersonnages = new JTextArea();

DocumentListener dl = new DocumentListener() {

    @Override
    public void removeUpdate(DocumentEvent e) {
        textChanged();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        textChanged();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // This method is not called when the text of the Document changed, but if attributes of the Document changed.
    }

    private void textChanged() {
        int nombMusc = Integer.valueOf(nbMuscle.getText());
        int nombFuy = Integer.valueOf(nbFuyard.getText());
        int nbTotal = nombMusc + nombFuy;
        nbPersonnages.setText(String.valueOf(nbTotal));
    }
};

int nombMusc = Integer.valueOf(nbMuscle.getText());
int nombFuy = Integer.valueOf(nbFuyard.getText());
int nbTotal = nombMusc + nombFuy;
nbPersonnages.setText(String.valueOf(nbTotal));

nbMuscle.getDocument().addDocumentListener(dl);
nbFuyard.getDocument().addDocumentListener(dl);