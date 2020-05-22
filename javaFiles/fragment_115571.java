et1.addTextChangedListener(new TextWatcher() {
  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) { 
      try{
         value = Double.parseDouble(text.getText().toString());
      } catch (final NumberFormatException e) {
         value = 1.0;
      }

      if(rb1.isChecked()){ mark = convertUp(value);  }
      else{ mark = convertDown(value); }

      tv1.setText(""+mark); //will update ur tV every time you input a lleter
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

  @Override
  public void afterTextChanged(Editable s) { }
});