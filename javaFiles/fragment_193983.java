public class DataHandlerDB{

    public static SQLiteDatabase createDB(Context ctx) {
        OpenHelper helper = new OpenHelper(ctx);
        SQLiteDatabase db = helper.getWritableDatabase();
        ...
        return db;
    }

    public static Cursor selectTopCalls(Context ctx) {
        OpenHelper helper = new OpenHelper(ctx);
        SQLiteDatabase db = helper.getWritableDatabase(); // error is here
        ...
        return c;
    }

}