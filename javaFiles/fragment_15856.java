final EditText editText = findViewById(R.id.editText);
final EditText editText2 = findViewById(R.id.editText2);

Button button = (Button) findViewById(R.id.btn);
    //set validation on button click like this
button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editText.getText().toString().isEmpty()) {

                Toast.makeText(getApplicationContext(), "Please enter number", Toast.LENGTH_SHORT).show();
            }else {
                int ans= Integer.parseInt(editText.getText().toString().trim());
               ans=ans*ans;
                editText2.setText(ans+"");
            }


        }
    });