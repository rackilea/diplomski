public class DataHandlerDB{
    OpenHelper _helper;
    SQLiteDatabse _db;

    public DataHandlerDB( Context ctx ){
        _helper = new OpenHelper(ctx);
        _db = _helper.getWritableDatabase();
    }

    public SQLiteDatabase createDB() {
        ...
        return db;
    }

    public Cursor selectTopCalls() {
        ...
        return c;
    }

}

public void setBasicContent() {

    ...

    DataHandlerDB handler = new DataHandlerDB( this );
    Cursor c = handler.selectValues();  //.selectTopCalls()?

    ...
}