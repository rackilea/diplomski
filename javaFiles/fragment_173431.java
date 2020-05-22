private void fillData() {
    mFrom = new String[] { NoteDbAdapter.KEY_TITLE };
    mTo = new int[] { R.id.textNote };

    // Now create an array adapter and set it to display using our row
    SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            R.layout.note_row_layout, mCursor, mFrom, mTo);

    setListAdapter(adapter);
}