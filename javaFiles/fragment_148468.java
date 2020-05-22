super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] proj = new String[] { Browser.BookmarkColumns.TITLE,
            Browser.BookmarkColumns.URL };
    String chnHistory = Browser.BookmarkColumns.BOOKMARK + " = 0"; // 0 = history,
    Cursor mycur = this.managedQuery(Browser.BOOKMARKS_URI, proj,
            chnHistory, null, null);
    this.startManagingCursor(mycur);
    mycur.moveToFirst();

    ArrayList<String> array = new ArrayList<String>();
    String title = "";
    String url = "";

    if (mycur.moveToFirst() && mycur.getCount() > 0) {
        while (!mycur.isAfterLast()) {
            title = mycur.getString(mycur
                    .getColumnIndex(Browser.BookmarkColumns.TITLE));
            url = mycur.getString(mycur
                    .getColumnIndex(Browser.BookmarkColumns.URL));
            array.add(title + " : " + url);
            mycur.moveToNext();
        }
    }

    if (array.size() > 0) {
        for (String string : array) {
            Log.d("result ", string);
        }
    }