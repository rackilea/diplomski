public class GetTable extends ListActivity {

static String team;
static int played;
static int won;
static int drew;
static int points;
private TableDbAdapter mDbHelper;
static int position = 0;


@Override
public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
    setContentView(R.layout.testlayout);
    mDbHelper = new TableDbAdapter(this);
       mDbHelper.open();
    mDbHelper.clearTable();
try {
    populateTexts();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
populateList();
}

    private void populateTexts() throws IOException{
    String url =     "http://news.bbc.co.uk/mobile/bbc_sport/rugby/competition/ru100/table/index.shtml?    context=cps_ukfs";

    Document doc = Jsoup.connect(url).get();

    //

  Elements rows = doc.select("table[class=tblResults teamTable] tr:gt(0):lt(13)");

        String s[] = new String[rows.size()];
        for(Element row : rows){
            s[0] = row.child(0).text();
            s[1] = row.child(1).text();
            s[2] = row.child(2).text();
            s[3] = row.child(3).text();
            s[4] = row.child(4).text();

        team = s[0];
        if (s[1] !=""){
        played = Integer.parseInt(s[1]);}
        else played = 0;
        if (s[2] !=""){
        won = Integer.parseInt(s[2]);}
        else won = 0;
        if (s[3] !=""){
        drew = Integer.parseInt(s[3]);}
        else drew = 0;
        if (s[4] !=""){
        points = Integer.parseInt(s[4]);}
        else points = 0;

        position ++;


    // sql insert
       mDbHelper.createTableRow(position, team, played, won, drew, points);



    }
    }

    private void populateList() {
           // Get all of the fixtures from the database and create the item list
           Cursor c = mDbHelper.fetchWholeTable();
           startManagingCursor(c);

           String[] from = new String[] { TableDbAdapter.KEY_POSITION, TableDbAdapter.KEY_TEAM, TableDbAdapter.KEY_PLAYED, TableDbAdapter.KEY_WINS, TableDbAdapter.KEY_DREW, TableDbAdapter.KEY_POINTS};
           int[] to = new int[] { R.id.fixtextlist, R.id.fixtextlistkotime, R.id.fixtextlisthome, R.id.fixtextlisths, R.id.fixtextlistas, R.id.fixtextlistaway};

           // Now create an array adapter and set it to display using our row
           SimpleCursorAdapter table =
               new SimpleCursorAdapter(this, R.layout.fixlist_item, c, from, to);
           setListAdapter(table);




       }
}