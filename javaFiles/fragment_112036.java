public void focusLost(FocusEvent arg0) {
    String telephone = businesAddressFields.get(TELEPHONE).getText());

    if (telephone.length()>0) {
        if (!telephone.matches(TELEPHONE_PATTERN)) {
            showMessage("Fehler: Telephonnummer: " + telephone + " ist nicht gültig!/nMeherer Adressen mit ' OR ' trennen.", JOptionPane.ERROR_MESSAGE);
            businesAddressFields.get(TELEPHONE).requestFocusInWindow();
        }
    }
}