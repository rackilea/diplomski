public void onClick(View view) {
    String currency;
    double rate;
    switch (view.getId()) {
        case R.id.button:
            currency = "$";
            rate = 1.41;
            break;
        case R.id.button2:
            currency = "€";
            rate = 1.14;
            break;
        default:
            throw new UnsupportedOperationException("Unknown button");
    }
    try {
        double p = Double.parseDouble(e.getText().toString());
        double d = p * rate;
        e.setText("£" + p + " = " + currency + d);
        adb.setTitle("£ to " + currency);
        adb.setMessage("£" + p + " = " + currency + d);
        adb.show();
    } catch (NumberFormatException e) {
        e.setText("Not a valid number: " + e.getText());
    }
}