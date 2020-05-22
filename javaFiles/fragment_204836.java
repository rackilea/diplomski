protected final TextWatcher getValueWatcher = new TextWatcher() {
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    public void onTextChanged(CharSequence s, int start, int before, int count) {
      if (s.length() > 0){
        int qty = Integer.parseInt(s.toString());
        int unitPrice = Integer.parseInt(unitPriceEdit.getText().toString());
        totalPriceEdit.setText(String.valueOf(qty * unitPrice));
      }
    }
    public void afterTextChanged(Editable s) {
    }
};