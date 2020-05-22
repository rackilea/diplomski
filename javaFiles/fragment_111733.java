public void afterTextChanged(Editable s) {
    // handle empty editText value and zero
  double etValue = Double.valueOf(editText.getText().toString());
  String input = s.toString();
  int len = input.length();
    for(int i=0; i<len; i++){
        etValue *= 10;
        etValue += Double.valueOf("0.0"+input.charAt(i));
    }
  editText.setText(String.valueOf(etValue));
}