@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    switch (id) {
        case LOADER:
            Uri uri = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;
            final String criteria = null;
            String[] columns = {
                    MediaStore.Audio.Playlists._ID,
                    MediaStore.Audio.Playlists.NAME,
            };
            return new CursorLoader(getActivity(), uri, columns, criteria, null, MediaStore.Audio.Playlists.NAME + " ASC");
        default:
            return null;
    }

}

@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
    mAdapter.swapCursor(data);
    mcursor=data;
    mAdapter.notifyDataSetChanged();
}

@Override
public void onLoaderReset(Loader<Cursor> loader) {
    mAdapter.swapCursor(null);
    mcursor=null;
    mAdapter.notifyDataSetChanged();
}