public void itemStateChanged(ItemEvent event) {
    price = 0;
    if (pineApple.isSelected()) {
        price = price + 2.30;
    }
    if (delivery.isSelected()) {
        price = price + 5;
    }
    if (drink.isSelected()) {
        price = price + 1;
    }
    if (meatballs.isSelected()) {
        price = price + 1;
    }

    priceField.setText("$" + price);
}