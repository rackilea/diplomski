ContentValues values = new ContentValues();

values.put(DatabaseHelper.KEY_VENUE_NAME, store.getName());
values.put(DatabaseHelper.KEY_VENUE_CITY, store.getCity());
values.put(DatabaseHelper.KEY_VENUE_STATE, store.getState());

//insert row
context.getContentResolver().insert(Uri.parse(ContentProvider.base_CONTENT_URI + index), values);