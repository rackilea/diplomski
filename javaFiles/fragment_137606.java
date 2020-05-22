//Here make sure **EditText02** is the id that you have declared in XML
et3 = (EditText) findViewById(R.id.EditText02);  //input type for edittext02 is number

et3.setOnClickListener(this);


public void onClick(View v){
       //Also here check the edittext02 id thats set in the xml layout
       if(v.getId() == R.id.EditText02){
          et3.setText("");
       }
}