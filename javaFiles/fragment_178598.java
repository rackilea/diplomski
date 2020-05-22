jtfMiles.getDocument().addDocumentListener(new DocumentListener() {

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (jtfMiles.hasFocus()) { // ADD THIS LINE
            if (jtfMiles.getText().equals("")) {
                jtfKilometers.setText("");
            } else {
                jtfKilometers.setText(Double.parseDouble(jtfMiles.getText()) * 1.60934 + "");
            }
        }
    }