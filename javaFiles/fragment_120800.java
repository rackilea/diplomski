public void addButtonListener()
{
     Button login=(Button)findViewById(R.id.button1);
     editText1=(EditText)findViewById(R.id.editText1);
     login.setOnClickListener(new OnClickListener(){
        public void onClick(View v){
            if(validationSuccess(editText1.getText().toString().trim())){
                 Intent intent = new Intent(Klogin.this, Login.class);
                 startActivity(intent);
             }
         }
     });
}