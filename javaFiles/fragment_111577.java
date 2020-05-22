public void onClick(View v) {
    if (digits.length() != 0) {
        digits = digits.substring(0, digits.length() - 1);
        Display.setText(digits);
    }
}