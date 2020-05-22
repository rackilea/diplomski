@Override
public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

    String tableName;
    int uriNum = uriMatcher.match(uri);

    switch (uriNum) {
        //Case 1 is for the entire Goals table
        case 1:
            break;

        //Case 2 is for a specific row in the Goals table
        case 2:
            if (selection != null) {
                selection = selection + "_ID = ? ";
            }
            else {
                selection = "_ID = ? ";
            }
            break;

        //Case 3 is for the entire Categories table
        case 3:
            break;

        //Case 4 is for a specific row in the Categories table
        case 4:
            if (selection != null) {
                selection = selection + "_ID = ? ";
            }
            else {
                selection = "_ID = ? ";
            }
            break;

        default:
            throw new IllegalArgumentException("URI not found.");
    }

    if(uriNum == 1 || uriNum == 2) {
        tableName = GoalsContract.Goals.TABLE_NAME;
    }
    else {
        tableName = CategoriesContract.Categories.TABLE_NAME;
    }

    db = dbHelper.getWritableDatabase();
    dbHelper.onCreate(db);

    Log.d(TAG, tableName + "\n" + selection + "\n");

    int count = db.update(tableName, values, selection, selectionArgs);

    getContext().getContentResolver().notifyChange(uri, null);

    return count;
}