public void addCups(View view) {
    numberOfCups = numberOfCups + 1;
    calculateTotal();
    display(numberOfCups);
    displayMessage(gBetrag + endPreis);
}

private void calculateTotal() {
    endPreis = NumberFormat.getCurrencyInstance().format(numberOfCups * priceOfCup);
}