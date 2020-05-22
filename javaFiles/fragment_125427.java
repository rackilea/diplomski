@Override
public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
    db.execSQL(
            "create table contacts " +
                    "(id integer primary key, name text,email text,pass text, dob text,gender text,phone text,city text)"
    );
}