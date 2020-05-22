@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor cursor)
    {
    if (cursor.moveToFirst())
        {           
        int textColumnIndex = cursor.getColumnIndex(NoteEntry.COLUMN_TEXT);

        content = cursor.getString(textColumnIndex);
        mEditView.setText(content);         
        }