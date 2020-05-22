class MyDocumentListener implements DocumentListener {

    public void insertUpdate(DocumentEvent e) {

        System.out.println(e.getType());
        searchF.setEditable(false);
        rangeTF1.setEditable(false);
        rangeTF2.setEditable(false);
        ageTF.setEditable(false);
        addressTF.setEditable(false);
        crimebox.setEnabled(false);
        countrybox.setEnabled(false);
        genderbox.setEnabled(false);
    }

    public void removeUpdate(DocumentEvent e) {

        if(idTF.getText().isEmpty()){

        searchF.setEditable(true);
        rangeTF1.setEditable(true);
        rangeTF2.setEditable(true);
        ageTF.setEditable(true);
        addressTF.setEditable(true);
        crimebox.setEnabled(true);
        countrybox.setEnabled(true);
        genderbox.setEnabled(true);
        }

    }

    public void changedUpdate(DocumentEvent e) {
    }


}