public boolean insertContact (String name, String email, String pass, String dob,String gender,String phone,String city) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("name", name);
    contentValues.put("email", email);
    contentValues.put("password", pass);
    //contentValues.put("date-of-birth", dob);
    // it should be "dob" instead of "date-of-birth"
    contentValues.put("dob", dob);
    // like this
    contentValues.put("gender", gender);
    contentValues.put("phone",phone);
    contentValues.put("city",city);
    db.insert("contacts", null, contentValues);
    return true;
}