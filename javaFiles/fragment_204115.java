//get the name the user entered
String enterName=getIntent().getStringExtra("PERSON_NAME");

EditText confirmationText = (EditText)findViewById(R.id.confirmationText);

confirmationText.setText(enterName);
finish();