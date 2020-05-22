public Integer[] getch() {

    SQLiteDatabase database = this.getReadableDatabase();
    Cursor cursor = database.rawQuery("SELECT sum(sales) FROM sales group by outlet_code order by ordered_date", null);
    // String[] array = new String[crs.getCount()];
    int columnIndex = 0;
    Integer[] in = new Integer[cursor.getCount()];

    if (cursor.moveToFirst())
    {
        for (int i = 0; i < cursor.getCount(); i++)
        {
            in[i] = cursor.getInt(columnIndex);
            cursor.moveToNext();
        }
    }
    cursor.close();
    return in;
}