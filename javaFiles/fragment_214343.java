public final class FooUtils {

    public static <T extends Foo> ArrayList<T> get(Context context, int categoryId, FooProcessing<T> fooProcessing) {
        ArrayList<T> items = new ArrayList<>();

        Cursor cursor = MyDbHelper.getInstance(context).getReadableDatabase.query(
                BaseSchema.TABLE_NAME,
                null,
                BaseSchema.COL_CATEGORY_ID + "=?",
                new String[] {String.valueOf(categoryId)},
                null,
                null,
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            items.add(fooProcessing.createFooInstance(cursor)); // ??
            cursor.moveToNext();
        }
        cursor.close();
    }
    // ...
    return items;

}