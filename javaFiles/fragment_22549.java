if (celsiusEdit.getText().toString().matches("")) {
    Toast.makeText(this, "Field cannot be empty", Toast.LENGTH_SHORT).show();
    return;
}else{
  double celsius = Double.valueOf(celsiusEdit.getText().toString());
  double farh = (celsius -32) * 5/9;

  farhEdit.setText(String.valueOf(farh));
}