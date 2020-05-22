nameEt = (EditText) findViewById(R.id.name_et);
    mobileEt = (EditText) findViewById(R.id.mobile_et);
    submitBtn = (Button) findViewById(R.id.submit_btn);
    submitBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name=nameEt.getText().toString();
            mobile_number=mobileEt.getText().toString();
            Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
            intent.putExtra("name",name);
            intent.putExtra("mobile",mobile_number);
            startActivity(intent);
        }
    });