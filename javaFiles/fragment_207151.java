public class Main extends ListActivity implements OnItemClickListener {

private DataBaseHelper myDbHelper;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    myDbHelper = new DataBaseHelper(this);

    try {
      myDbHelper.createDataBase();
    } catch (IOException ioe) {
    throw new Error("Unable to create database");
    }
    try {
    myDbHelper.openDataBase();
    }catch(SQLException sqle){

    throw sqle;

}

try {

    Cursor cursor = getPlaces();
    showPlaces(cursor);

}

finally {

myDbHelper.close();

}
}

private static String[] FROM = { _ID, AREA, ADDRESS, UNIQUEID};
private static String ORDER_BY = _ID + " ASC";

private Cursor getPlaces() {

    SQLiteDatabase db = myDbHelper.getReadableDatabase();
    Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, ORDER_BY);
    startManagingCursor(cursor);
    return cursor;

}

private static int[] TO = {R.id.name, R.id.description, R.id.address, };
private void showPlaces(Cursor cursor) {

    MyCustomAdapterClass adapter = new MyCustomAdapterClass(this,cursor, true); setListAdapter(adapter); 

}

@Override
    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
        Log.e("Position",""+position);

    }