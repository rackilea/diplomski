nameEditText.addTextChangedListener(new TextWatcher() {

   @Override
   public void afterTextChanged(Editable s) {}

   @Override
   public void beforeTextChanged(CharSequence s, int start,
     int count, int after) {
   }

   @Override
   public void onTextChanged(CharSequence s, int start,int before, int count) {
      messageEditText.setText("Hello " + s + " could you please review our app")
   }
  });