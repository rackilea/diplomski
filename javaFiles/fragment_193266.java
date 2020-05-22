private class DatabaseHelper extends SQLiteOpenHelper {

    private static final String ENCODING = "UTF-8";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //DATABASE_NAME is just a name of database

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(COMMAND_CREATE_TABLE);
        //COMMAND_CREATE is just command to create table i.e.
        //CREATE TABLE myTable ( _id int...

        try {
            InputStream inputStream = this.context.getResources().openRawResource(R.raw.my_base_file);
            BufferedReader bufferReader;

            if (inputStream != null) {
                bufferReader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));

                String line = "";

                while ((line = bufferReader.readLine()) != null) {
                    db.execSQL(COMMAND_INSERT_START + line + COMMAND_INSERT_END);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myTable");
        onCreate(db);
    }

}

public Cursor fetchAllRows() {
    SQLiteDatabase localSQLiteDatabase = this.sqlDatabase;
    return localSQLiteDatabase.query("myTable", ROWS_COLUMNS_NAME, null, null, null, null, null);
}