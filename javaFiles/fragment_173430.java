private void fillData() {
    String note;
    notes = new ArrayList<String>();

    // Populate arraylist with database data
    if (mCursor.moveToFirst()) {
        do {
            // Get current row's character and line
            note = mCursor.getString(mCursor.getColumnIndex("title"));
            Log.d(TAG, "Adding note: " + note);
            notes.add(note);
        } while (mCursor.moveToNext());
    }

    // Fill list with our custom adapter
    NoteAdapter adapter = new NoteAdapter(this, R.layout.note_row_layout,
            notes);
    setListAdapter(adapter);
}