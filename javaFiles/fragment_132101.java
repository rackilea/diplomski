if (count == 4) {
        SQLiteDatabase sqdb = my_db.getWritableDatabase();

        Cursor c_oldPoints= sqdb.query(
                DBHelper.TABLE_NAME2,null,
                DBHelper.NICKNAME+"=?",
                new String[]{Username},
                null,null,null
        );
        int col_Points=c_oldPoints.getColumnIndex(DBHelper.POINTS);
        if (c_oldPoints.moveToFirst()) {
            Oldpoints = c_oldPoints.getString(col_Points);
            //Oldpoints = "oops";
            int OldP = 0;
            boolean can_convert_to_int = true;
            try {
                OldP = Integer.parseInt(Oldpoints) + countPoints;
                can_convert_to_int = true;
            } catch (NumberFormatException e) {
                e.printStackTrace(); //TODO not necessary probably remove. just for checking the log 
            }

            if (can_convert_to_int) {
                ContentValues cv = new ContentValues();
                cv.put(DBHelper.POINTS,OldP);
                sqdb.update(DBHelper.TABLE_NAME2,cv, DBHelper.NICKNAME + "=?", new String[]{Username});
            }
        } else {
            Log.d("NICKNAMENOTFOUND","No row was found when attemtping to get the old score for User " + Username);
        }
    }