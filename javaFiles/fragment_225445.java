@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {

    return new SQLiteCursorLoader(getActivity()) {
        @Override
        public Cursor loadInBackground() {

            Cursor cursor;
            cursor = TasksLab.getTasks();

            // Register the cursor with the content observer
            this.registerContentObserver(cursor, DBConstants.DB_TABLE_TASKS_URI);
            return cursor;
        }
    };
}

@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
    // Set the cursor in the adapter of your RecyclerView here. 
}

@Override
public void onLoaderReset(Loader<Cursor> loader) {

}

// Do not forget to destroy the loader when you are destroying the view.
@Override
public void onDestroy() {
    getLoaderManager().destroyLoader(TASKS_QUERY_LOADER);
    super.onDestroyView();
}