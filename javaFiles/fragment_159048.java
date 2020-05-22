//get EditText's value, I will assume you want it to be an int 
//just to show you how to save it
//later, we're doing the same with String
//NOTE: no checks are done for correct input, the below will fail
//if myEditText's content is not valid to be converted to int
EditText myEditText = (EditText)findViewById(R.id.myEditText);

int value = Integer.parseInt(myEditText.getText().toString());

// We need an Editor object to make preference changes.
SharedPreferences settings = getSharedPreferences("mySettings", Activity.MODE_PRIVATE);
SharedPreferences.Editor editor = settings.edit();
editor.putString("value", value);

// Commit the edits!
editor.commit();