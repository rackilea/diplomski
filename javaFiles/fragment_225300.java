public void onCreate(SQLiteDatabase database) {

  [... code code code ...]

   String customTimerSessionTableQuery =
          "CREATE TABLE "
                  + CUSTOM_TIMER_SESSION_TABLE + "("
                  + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                  + "name TEXT,"
                  + "rounds INTEGER,"
                  + "date DATETIME DEFAULT CURRENT_TIMESTAMP)";

  String customTimerTableQuery =
          "CREATE TABLE "
                  + CUSTOM_TIMER_TABLE + " ("
                  + "timerId INTEGER PRIMARY KEY AUTOINCREMENT,"
                  + "name TEXT,"
                  + "millis INTEGER,"
                  + "metronome BOOL,"
                  + "rpm INTEGER,"
                  + "type INTEGER,"
                  + "sessionId INTEGER NOT NULL)";

  database.execSQL(sessionTableQuery);
  database.execSQL(exerciseTableQuery);
  database.execSQL(customTimerSessionTableQuery);
  database.execSQL(customTimerTableQuery);

  // SAMPLE DATA
  database.execSQL("INSERT INTO custom_timer_session VALUES(1,'Tabata',8,'2014-10-21 12:00:00')");
  database.execSQL("INSERT INTO custom_timer VALUES(1,'WORK',20000,0,20,0,1)");
  database.execSQL("INSERT INTO custom_timer VALUES(2,'REST',10000,0,20,1,1)");   }