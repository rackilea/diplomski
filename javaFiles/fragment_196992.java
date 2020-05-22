final EditText edt = (EditText) findViewById(R.id.editText);

        edt.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (edt.length() == 0 && edt.hasFocus()) {
                    edt.setText("+");
                    edt.setSelection(1);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (edt.getText().length() == 0) {
                        edt.setText("+");
                    }
                } else {
                    if(edt.getText().toString().length() == 1) {
                        edt.setText("");
                    }
                }
            }
        });