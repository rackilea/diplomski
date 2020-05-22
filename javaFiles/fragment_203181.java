EditText et1 = (EditText)findViewById(R.id.editText1);
EditText et2 = (EditText)findViewById(R.id.editText2);
//Do same for All EditTexts

Button button= (Button)findViewById(R.id.btn1);
button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
             int number = Integer.parseInt(et1.getText().toString());
             //Do same for All EditTexts
        }
    });