MainData helper = new MainData(this); //Change the name to your Helper Class name
SQLiteDatabase db = helper.getWritableDatabase();
ContentValues contentValues = new ContentValues();
//contentValues.put(KEY_ID, MessageRecieverId); //<<<<<<<<<< COMMENTED OUT (can delete the line)
contentValues.put(KEY_NAME, MessageRecieverName);
contentValues.put(KEY_MESSAGES_SENT, 0);
contentValues.put(KEY_MESSAGES_RECIEVED, 0);
contentValues.put(KEY_TIME_SPENT, "");

long returnVariable = db.insert(TABLE_USER_DATA,null,contentValues);
if (returnVariable == -1) {
    Toast.makeText(getApplication(), "Nope", Toast.LENGTH_LONG).show();