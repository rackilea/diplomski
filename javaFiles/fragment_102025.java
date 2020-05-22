String[] myString;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // "TPBDB stuff"
    TPBDB = openOrCreateDatabase("TPBDB1", MODE_PRIVATE, null);
    Cursor cur = TPBDB.rawQuery("SELECT * from Vogel", null);
    String mycur = cur.toString();
    int count = cur.getCount();

    myString = new String[count]; // init array here

    ...
}