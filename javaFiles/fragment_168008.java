bak.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText focusEditText=et1;
            if (et1.hasFocus()) {
                focusEditText=et1;
            }
            if (et2.hasFocus()){
                focusEditText=et2;
            }
            String str = focusEditText.getText().toString();
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 1);
                focusEditText.setText(str);
            } else if (str.length() <= 1) {
                focusEditText.setText("");
            }
        }

    });