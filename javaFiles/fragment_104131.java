private void fillData() {
    // Get all of the rows from the database and create the item list
    Cursor notesCursor = mDbHelper.fetchAllNotes();
    startManagingCursor(notesCursor);

    // The list that will back our table, this could be turned into a member variable.
    List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    // Get the column indexes
    int titleColumnIndex = notesCursor.getColumnIndex(NotesDbAdapter.KEY_TITLE);
    int bodyColumnIndex = notesCursor.getColumnIndex(NotesDbAdapter.KEY_BODY);

    // Iterate through all of the cursor rows to fill the adapter
    while (notesCursor.moveToNext()) {
        String title = notesCursor.getString(titleColumnIndex);
        String body = notesCursor.getString(bodyColumnIndex);

        HashMap<String,String> temp = new HashMap<String,String>();
        temp.put("title", title);
        temp.put("body", body);
        list.add(temp);
    }

    //Here I want to use a SimpleAdapter to display the title and body of the Note
    SimpleAdapter adapter = new SimpleAdapter
            (this, list, R.layout.custom_row_view, new String[] {"title","body"}, new int[] {R.id.text11,R.id.text2});
    setListAdapter(adapter);
}