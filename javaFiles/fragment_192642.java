public List<DailyData> getAll() {
    List<DailyData> list = new ArrayList<>();

    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(TABLE_DAILY_DATA, null, null, null, null, null, null);
    try {
        if (cursor_daily_data.moveToFirst()) {
            do {
                DailyData dailyData = new DailyData();
                dailyData.time = cursor_daily_data.getString(0);
                dailyData.summary = cursor_daily_data.getString(1);
                dailyData.icon = cursor_daily_data.getString(2);
                dailyData.sunriseTime = cursor_daily_data.getString(3);
                dailyData.sunsetTime = cursor_daily_data.getString(4);
                dailyData.moonPhase = cursor_daily_data.getString(5);
                dailyData.precipIntensity = cursor_daily_data.getString(6);
                dailyData.precipIntensityMax = cursor_daily_data.getString(7);
                list.add(dailyData);
            } while (cursor_daily_data.moveToNext());
        }
    } catch (Exception e) {
        Log.d(TAG, "Error while trying to get data from database");
    } finally {
        if (cursor_daily_data != null && !cursor_daily_data.isClosed()) {
            cursor_daily_data.close();
        }
    }
    return list;
}