@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    // The last case will contain the break statement only. As the migration will take place one by one.
    // Here's a nice explanation - http://stackoverflow.com/a/26916986/3145960
    switch (oldVersion) {
        case 1:
            doSomeChangesInDBForVersion1();
        case 2:
            doSomeChangesInDBForVersion2();
            break;
    }
}