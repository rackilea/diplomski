public void actionPerformed(ActionEvent event) {
    try {
        Double.parseDouble(fahr.getText());
    } catch (NumberFormatException e) {
        fahr.setText("0");
        // display a JOptionPane error message so the user knows there's been a problem
        return; // so the code below isn't called if input in error
    }
    String fahrText = fahr.getText();
    fahrVal = Double.parseDouble(fahrText);
    fahrConv = ((fahrVal - 32)*5)/9;
    fahrConv = Double.parseDouble(new DecimalFormat("##.#").format(fahrConv));

    String celsText = cels.getText();
    celsVal = Double.parseDouble(celsText);
    celsConv = 32 + (celsVal * 9 / 5);
    celsConv = Double.parseDouble(new DecimalFormat("##.#").format(celsConv));
}