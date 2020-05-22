try {
    cashRecieved = Double.parseDouble(CashNeeded.getText());
} catch (NumberFormatException e) {
    e.printStackTrace();
    // handle the error
}