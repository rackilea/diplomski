final EditText currentGradeInput = (EditText)findViewById(R.id.currentGradeInput);


   currentGradeInput.addTextChangedListener(new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            currentGradeValue = Float.valueOf(currentGradeInput.getText().toString());
       }

       @Override
       public void afterTextChanged(Editable editable) {

       }
   });