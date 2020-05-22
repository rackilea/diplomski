public class SQLiteStatementExtension  {

    public static void BindNullable(SQLiteStatement statement, int index, String value)
    {
        if(value == null){
            statement.bindNull(index);
        } else {
            statement.bindString(index, value); 
        }
    }

    public static void BindNullable(SQLiteStatement statement, int index, Calendar value)
    {
        if(value == null){
            statement.bindNull(index);
        } else {
            statement.bindLong(index, value.getTimeInMillis()); 
        }
    }

    public static void BindNullable(SQLiteStatement statement, int index, byte[] value)
    {
        if(value == null){
            statement.bindNull(index);
        } else {
            statement.bindBlob(index, value);   
        }
    }

    public static void Bind(SQLiteStatement satement, int index, boolean value) {
        satement.bindLong(index, value ? 1 : 0);
    }
}