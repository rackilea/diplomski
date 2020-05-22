jtfKilometers.getDocument().addDocumentListener(new DocumentListener() {

@Override
public void insertUpdate(DocumentEvent e) {
    if (jtfKilometers.hasFocus()) { // ADD THIS LINE
        if (jtfKilometers.getText().equals("")) {
            jtfMiles.setText("");
        } else {
            jtfMiles.setText(Double.parseDouble(jtfKilometers.getText()) * 0.621371 + "");
        }
    }
}