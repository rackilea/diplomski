final Cursor cursor = db.rawQuery("SELECT SUM(odometer) as odometer FROM tripmileagetable where date like '2012-07%';", null);
int sum = 0;
if (cursor != null) {
    try {
        if (cursor.moveToFirst()) {
            sum = cursor.getInt(0);
        }
    } finally {
        cursor.close();
    }
}