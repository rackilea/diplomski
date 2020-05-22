public class StudyManagerDataSource {

    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

public StudyManagerDataSource(Context context) {
            dbHelper = new DatabaseAdapter(context);

        }

public void addAlarm(Alarm alarm)
{  

    // open the database connection 
    open();
    ContentValues values = new ContentValues();

    values.put(KEY_DESC, alarm.getDesc());
    values.put(KEY_REPEAT_DAY, alarm.getRepeatDay());
    values.put(KEY_REPEAT_TYPE, alarm.getRepeatType());
    values.put(KEY_CALENDAR, Long.toString(alarm.getCalendarInMillis()));
    values.put(KEY_APP, alarm.getApp());
    values.put(KEY_ACTIVE, alarm.getActive());
    database.insert(TABLE_NAME, null, values);
    // I will suggest to keep the connection to the database open when your app is 
    // running, the recommended time to close the connection is when your app is 
    //going to pause/stop.
    close();
}

public void open() {
        database = dbHelper.getWritableDatabase();
        Log.i(LOG_TAG, "Database Opened");
    } // end method open

public void close() {
        Log.i(LOG_TAG, "Database Closed");
        dbHelper.close();
    } // end method close
}