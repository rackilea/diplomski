DefaultListModel validatorDLM = new DefaultListModel();  //Specifically for validation
DefaultListModel orderDLM = new DefaultListModel();
String theItem = "Bananas";  //This changes with combo box
BigDecimal theQuantity = new BigDecimal(quantity.getText());
BigDecimal thePrice = new BigDecimal(0.00); //This changes depending on quanitity
thePrice = thePrice.setScale(2, BigDecimal.ROUND_HALF_UP);

if (!validatorDLM.contains(theItem)) {
    validatorDLM.addElement(theItem);
    orderDLM.addElement(theItem + " $" + thePrice.toString());
    jList.setModel(orderDLM);
    //More code
} else {
    JOptionPane.showMessageDialog(mainPanel, "You already selected that item", "Error Dialog", JOptionPane.ERROR_MESSAGE);
    return;
}