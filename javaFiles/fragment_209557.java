public boolean isExist(String strEmailAdd) {
        db = this.getReadableDatabase();
        cur = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE email_id = '" + strEmailAdd + "'", null);
        boolean exist = (cur.getCount() > 0);
        cur.close();
        db.close();
        return exist;

    }