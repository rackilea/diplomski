db.execSQL(
    "create table " + TASKS_TABLE +" (" +
    TASK_ID + " integer primary key autoincrement not null," +
    TASK_NAME + " text," +
    TASK_COMPLETE + " text," +
    TASK_RESPONSIBLE + " text" + // <--- missing a comma
    TASK_PRIORITY + " integer" +
    ");"
);