private class DoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("0.00");

        String weightStr = textField.getText();
        weight = Double.parseDouble(weightStr);

        String valueStr = insurancevaluetextField.getText();
        value = Double.parseDouble(valueStr);
   .... }