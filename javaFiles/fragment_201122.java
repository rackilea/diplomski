//Main layout ID in your activity_main.xl
LinearLayout mainLayout = (LinearLayout) findViewById(R.id.linearLayoutHorizontal);

//Creating the edittext
EditText editTextOne = new EditText(this);

//You can also add properities here
editTextOne.setHint("Hello World");
editTextOne.setHintTextColor(Color.CYAN);

//Adding the edittext to the xml file
mainLayout.addView(editTextOne);