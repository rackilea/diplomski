NumberFormat numberFormatter = new DecimalFormat("#,###,###");
String formattedNumber = numberFormatter.format(10000000);

JTextField numberTextField = new JTextField();

numberTextField.setText(formattedNumber);