public class ContactDB {

    public static final String TBNAME = "contact";
    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_NAME = "contact_name";
    public static final String COL_EMAIL = "contact_email";

    public static String getTableCreatSQL() {
        return "CREATE TABLE IF NOT EXISTS " + TBNAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_NAME + " TEXT," +
                COL_EMAIL + " TEXT" +
                ")";
    }

    public static long addContact(SQLiteDatabase db, String contact_name, String contact_email) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,contact_name);
        cv.put(COL_EMAIL,contact_email);
        return db.insert(TBNAME,null,cv);
    }

    public static Cursor getAllContacts(SQLiteDatabase db) {
        return db.query(TBNAME,null,null,null,null,null,COL_NAME + " ASC," + COL_EMAIL + " ASC");
    }
}