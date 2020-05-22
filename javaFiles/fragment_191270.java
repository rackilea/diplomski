public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Spinner leadersSpinner;
    SimpleCursorAdapter leaderAdapter;
    Cursor leaders;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        databaseHelper = new DatabaseHelper(this); //<<<<<<<<<< prepre to use Database
        leadersSpinner = this.findViewById(R.id.leaders_spinner); //<<<<<<<<<< get the Spinner
        addSomeScoutsForTesting(); //<<<<<<<<<< Add some data for testing
        setOrRefreshSpinner(); //<<<<<<<<<< prepare the spinner
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        leaders.close(); //<<<<<<<<<< Close the Cursor when the activity is done with
    }

    private void setOrRefreshSpinner() {
        leaders = databaseHelper.getLeaders();
        if (leaderAdapter == null) {
            String[] columns = new String[]{DatabaseHelper.COLUMN_FNAME, DatabaseHelper.COLUMN_LNAME};
            leaderAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,leaders,columns,new int[]{android.R.id.text1,android.R.id.text2},0);
            leadersSpinner.setAdapter(leaderAdapter);
            leadersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String fname = leaders.getString(leaders.getColumnIndex(DatabaseHelper.COLUMN_FNAME));
                    String lname = leaders.getString(leaders.getColumnIndex(DatabaseHelper.COLUMN_LNAME));
                    Toast.makeText(
                            context,
                            "You clicked the Scout " +
                                    fname + " " + lname +
                                    " whoose ID is " + String.valueOf(l) +
                                    " at position " + String.valueOf(i) +
                                    " in the Spinner.",
                            Toast.LENGTH_SHORT
                    ).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        } else {
            leaderAdapter.swapCursor(leaders);
        }
    }

    private void addSomeScoutsForTesting() {

        // Only add if there are none
        if (DatabaseUtils.queryNumEntries(databaseHelper.getWritableDatabase(),databaseHelper.TABLE_SCOUTS) > 0) return;

        databaseHelper.addScout("Tony","Smith","Leaders");
        databaseHelper.addScout("Anne","Taylor","Something else");
        databaseHelper.addScout("Mary","Bloggs","Leaders");
        databaseHelper.addScout("Sue","Franks","Leaders");
        databaseHelper.addScout("Alan","Jones","Cubs Scouts");
        databaseHelper.addScout("Belinda","Forrestor","Venturers");
    }
}