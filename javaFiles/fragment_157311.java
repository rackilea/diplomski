public boolean checkAuthentication(String login, String password){
    boolean check = false;
    String sql = "SELECT * from Visiteur WHERE vis_login = ? and vis_mdp = ?";
    SQLiteDatabase db = dbManager.getWritableDatabase();
    Cursor cursor = db.rawQuery(sql, new String[] {login, password});
    check = cursor.moveToFirst();
    cursor.close();
    db.close();
    return check;
}