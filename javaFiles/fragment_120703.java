public class MessageLocalDB extends SQLiteOpenHelper {


    private static MessageLocalDB mDB;
    private static final String MSG_TABLE_NAME = "message_table";
    private static final String KEY_SRNO = "SRNO";
    private static final String KEY_ENQUIRYID = "ENQUIRYID";
    private static final String KEY_OPERATORID = "OPERATORID";


    public static synchronized MessageLocalDB getInstance(Context context, String StrDBNAme){
        if (mDB==null){
            mDB= new MessageLocalDB(context.getApplicationContext(),StrDBNAme);
        }
        return mDB;
    }

    private MessageLocalDB(Context context, String StrDBNAme) {
        super(context,StrDBNAme,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String strQueryComment = "create table " +
                MSG_TABLE_NAME + "(SRNO string,ENQUIRYID string,OPERATORID string)";
        db.execSQL(strQueryComment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_MSG_TABLE = "DROP TABLE IF EXISTS" + MSG_TABLE_NAME;
        db.execSQL(DROP_MSG_TABLE);
    }

    public void insertMSG(String srno,String enquiryid,String operatorid,String operatorname,String message,String time,String msgtype){
        SQLiteDatabase sqdb=getWritableDatabase();
        sqdb.beginTransaction();
        try{
            ContentValues values= new ContentValues();
            values.put(KEY_SRNO,srno);
            values.put(KEY_ENQUIRYID,enquiryid);
            values.put(KEY_OPERATORID,operatorid);
            sqdb.insert(MSG_TABLE_NAME,null,values);
            sqdb.setTransactionSuccessful();
        }catch (Exception ee){ee.printStackTrace();}
        finally {
            sqdb.endTransaction();
            sqdb.close();
        }
    }

    public Cursor fetchMSG(int enquiryid){
        SQLiteDatabase sqdb=getReadableDatabase();
        return  sqdb.rawQuery("select * from "+MSG_TABLE_NAME+" where "+KEY_ENQUIRYID+"=" + enquiryid + "", null);

    }
}