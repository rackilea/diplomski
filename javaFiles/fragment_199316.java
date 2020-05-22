// get the text entered by the user, also trim it for extra spaces
String newTableName = editTextInput.getText().trim(); 
// the entered name should consist only of characters
newTableName = newTableName.replaceAll("[^a-zA-Z]", "");
// create the new table
sqliteDatabase.execSQL("CREATE TABLE " + newTableName);