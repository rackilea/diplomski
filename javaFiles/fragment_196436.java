int counter;    // this is global, because otherwise needs to be final

void calculate() {

    for (counter = 0; counter < limit; counter++) {

        a[counter].getDocument().addDocumentListener(
                new MyDocumentListener(counter)); 

    }
}

class MyDocumentListener implements DocumentListener {
    int counter;

    public MyDocumentListener(int counter) {
        this.counter = counter;
    }

    public void insertUpdate(DocumentEvent e) {
        in = a[counter].getText();
        // this fails, because in case of a text edit in any
        // of JTextFields
        // the code that executes is the one with counter = limit
    }

    public void removeUpdate(DocumentEvent e) {
        in = a[counter].getText();
    }

    public void changedUpdate(DocumentEvent e) {
        in = a[counter].getText();
    }
}