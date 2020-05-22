public class CompanyDB {

    public static final String TBNAME = "company";
    public static final String COL_ID = BaseColumns._ID;
    public static final String  COL_NAME = "company_name";


    public static String getTableCreateSQL() {
         return "CREATE TABLE IF NOT EXISTS " + TBNAME + "(" +
                 COL_ID + " INTEGER PRIMARY KEY," +
                 COL_NAME + " TEXT" +
                 ")";
    }

    public static long addCompany(SQLiteDatabase db, String company_name ) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,company_name);
        return db.insert(TBNAME,null,cv);
    }

    public static Cursor getAllCompanies(SQLiteDatabase db) {
        return  db.query(TBNAME,null,null,null,null,null,COL_NAME + " ASC");
    }
}