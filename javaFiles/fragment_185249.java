@Override
protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
 if (resultCode == RESULT_OK) {
    Bundle extras = intent.getExtras();
    switch(requestCode) {
        case ACTIVITY_CREATE:
            String title = extras.getString(NotesDbAdapter.KEY_TITLE);
            String body = extras.getString(NotesDbAdapter.KEY_BODY);
            mDbHelper.createNote(title, body);
            fillData();
            break;
        case ACTIVITY_EDIT:
            Long rowId = extras.getLong(NotesDbAdapter.KEY_ROWID);
            if (rowId != null) {
                String editTitle = extras.getString(NotesDbAdapter.KEY_TITLE);
                String editBody = extras.getString(NotesDbAdapter.KEY_BODY);
                mDbHelper.updateNote(rowId, editTitle, editBody);
            }
            fillData();
            break;
    }
}
}