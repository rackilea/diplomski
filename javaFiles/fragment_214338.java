public abstract class AbstractFooProcessing<T extends Foo> {

    public abstract T createFooInstance(Cursor cursor);

    public ArrayList<T> get(Context context, int categoryId) {
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
            items.add(createFooInstance(cursor));
            cursor.moveToNext();
        }
        cursor.close();
    }

    // ...

}