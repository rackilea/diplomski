db = dbHelper.getReadableDatabase();
    Cursor cursor = db.query("stateTable", null, null, null, null, null, null);
    try {
        cursor.moveToPosition(id - 1);
        int i = cursor.getInt(2);
        android.util.Log.d("semajhan", ": " + i);
        if (i == 1) {
                return true;
        } else {
                return false;
        }
    } finally {
        cursor.close();
    }