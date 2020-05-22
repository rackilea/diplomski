ContentValues updatedValues = new ContentValues();
updatedValues.put(CategoriesContract.Categories.COLUMN_NAME_NAME, "Work 2.0");

Uri uri = ContentUris.withAppendedId(CategoriesContract.Categories.CONTENT_URI, 1);

int count = getContentResolver().update(uri, updatedValues, null, new String[]{String.valueOf(1));