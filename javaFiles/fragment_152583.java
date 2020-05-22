private void updateQuantity(int number) {
    TextView quantity = (TextView) findViewById(
            R.id.quantityValue);
    quantity.setText(String.valueOf(number));
}

private void updatePrice(int number) {
    TextView price = (TextView) findViewById(R.id.priceValue);
    price.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(number * 5)));
    }
}