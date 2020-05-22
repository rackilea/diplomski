public void addContacts(String phoneNumber, String text, Context context) {
    if (phoneNumber.isEmpty())
        return;

    SQLiteDatabase mDatabase = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put("phoneNumber", phoneNumber);
    values.put("text", text);

    mDatabase.insert("contact_msg", null, values);
    mDatabase.close();
    Toast.makeText(context, "contacts added", Toast.LENGTH_SHORT).show();
}