// Eg: format "123123123" as "123,123,123"
if (newValue.matches("\\d*")) {
    DecimalFormat formatter = new DecimalFormat("#,###");
    String newValueStr = formatter.format(Double.parseDouble(newValue));

    txtPrice.setText(newValueStr);
}