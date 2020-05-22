// In any activity just pass the context and use the singleton method
PostsDatabaseHelper helper = PostsDatabaseHelper.getInstance(this);
// or
PostsDatabaseHelper helper = PostsDatabaseHelper.getInstance(context);
// or
PostsDatabaseHelper helper = PostsDatabaseHelper.getInstance(getActivity());
// Do something with data via Cursor and
helper.close();