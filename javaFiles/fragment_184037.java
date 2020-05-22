private String cursorFilter;

@Override
public boolean onQueryTextChange(String newText) {
    cursorFilter = !TextUtils.isEmpty(newText) ? newText : null;
    getLoaderManager().restartLoader(0, null, this);
    return true;
}

@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    Uri baseUri;
    if (cursorFilter != null) {
        // Filter the data with the cursorFilter
        baseUri = Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI,
                                       Uri.encode(cursorFilter));
    } else {
        baseUri = MyContentProvider.CONTENT_URI;
    }

    ...
}