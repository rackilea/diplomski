double value = 0.0;
try {
    value = Double.parseDouble(field1.getText().toString());
} catch (NumberFormatException e) {
    field1.setText("0");
    e.printStackTrace();
}