public boolean isExist(String strEmailAdd){

        String whereClause = "email_id = ?";
        String[] whereArgs = new String[]{strEmailAdd};

        db = database.getWritableDatabase();
        cur = db.query(USER_TABLE, null, whereClause, whereArgs, null, null, null);
        boolean exist = (cur.getCount() > 0);
        cur.close();
        db.close();
        return exist;
}