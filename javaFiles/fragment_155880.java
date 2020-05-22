public class ImgDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "myimagestore";
    public static final String TBLNAME = "images";
    public static final String ID_COL = "_id";
    public static final String DSCR_COL = "description";
    public static final String PATH_COL = "path"; //<<<<<<<<

    SQLiteDatabase db;

    ImgDBHelper(Context context) {
        super(context,DBNAME,null,1);
        db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {    
        String crtsql = "CREATE TABLE IF NOT EXISTS " + TBLNAME + "(" +
                ID_COL + " INTEGER PRIMARY KEY, " +
                DSCR_COL + " TEXT," +
                PATH_COL + " TEXT" +
                ")";
        db.execSQL(crtsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addImageRow(String path, String description) {
        Cursor csr = db.query(TBLNAME,null,PATH_COL + "=?",new String[]{path},null,null,null);

        // DO NOT ADD DUPLICATE IMAGES (according to path)
        if (csr.getCount() > 0) {
            csr.close();
            return;
        }
        csr.close();

        ContentValues cv = new ContentValues();
        cv.put(DSCR_COL,description);
        cv.put(PATH_COL,path);

        db.insert(TBLNAME,null,cv);
    }

    public Cursor getAllImages() {
        return db.query(TBLNAME,null,null,null,null,null,null);
    }

    public String getImagePathFromID(long id) {
        String rv = "";
        Cursor csr = db.query(TBLNAME,
                null,
                "_id=?",
                new String[]{Long.toString(id)},
                null,null,null
        );
        if (csr.moveToFirst()) {
            rv = csr.getString(csr.getColumnIndex(PATH_COL));
        }
        csr.close();
        return rv;
    }

    public boolean areImagesLoaded() {
        Cursor csr = db.query(TBLNAME,null,null,null,null,null,null);
        boolean rv = (csr.getCount() > 0);
        csr.close();
        return rv;
    }
}