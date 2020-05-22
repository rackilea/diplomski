public String checkLogin(String username)
{
    Cursor cursor = database.query("users", null,  "username"+ "='" + username.trim() + "'",
                null, null, null, null);

    if(cursor == null || cursor.getCount() == 0) return "";
    cursor.moveToFirst();
    String password =  cursor.getString(cursor.getColumnIndex("password"));  
    return password;
}