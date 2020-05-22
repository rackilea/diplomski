public class SearchResults extends ListActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      setContentView(R.layout.searchresults);

        DbManager myDbHelper = new DbManager(null);
        myDbHelper = new DbManager(this);

        // Get the intent, verify the action and get the query

        myDbHelper.createNewDatabase();


        try {
            myDbHelper.open();
            Log.d("Search Results", "database opened");
        } catch (SQLException sqle) {
            throw sqle;
        }

        Intent intent = getIntent();
        String query = intent.getStringExtra(SearchManager.QUERY);

        // Executing our query against the server using rawQuery and getting the
        // cursor
        String select = "SELECT DISTINCT b._ISBN as _id, b.BookTitle, b.Edition, b.Year, b.Pages, b.Rating, c.Category, p.Publisher, w.LastName"
                + "   FROM"
                + "   Books b"
                + "   JOIN Categories_Books cb ON cb._Books_ISBN = _id"
                + "   JOIN Categories c ON c._CategoryID = cb._Categories_CategoryID"
                + "   JOIN Publishers p ON p._PublisherID = b.PublisherID"
                + "   JOIN Writers_Books wb ON wb._Books_ISBN = _id"
                + "   JOIN Writers w ON w._WriterID = wb._Writers_WriterID"
                + "   WHERE b.BookTitle LIKE '%"
                + query
                + "%'"
                + "   OR c.Category LIKE '%"
                + query
                + "%'"
                + "   OR p.Publisher LIKE '%"
                + query
                + "%'"
                + "   OR w.LastName LIKE '%"
                + query
                + "%'"
                + "   OR _id LIKE '%"
                + query
                + "%'"
                + "   GROUP BY b.BookTitle";

        Cursor c = myDbHelper.rawQ(select);
        startManagingCursor(c);

        // the desired columns to be bound
        String[] columns = new String[] { "Books.BookTitle",
                "Publishers.Publisher" };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.ISBN_entry, R.id.Title_entry };

        // Getting results into our listview
        try {
            SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this,
                    R.layout.listlayout, c, columns, to);
            this.setListAdapter(mAdapter);
        } catch (Exception e) {

        }
    }
}