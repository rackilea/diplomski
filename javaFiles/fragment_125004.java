public class MyProvider extends ContentProvider {
...
// JOIN paths
    private static final String PATH_RELATIONSHIP_JOIN_PERSON_GET_RELATIVES = 
            "relationship_join_person_get_relatives";
...
public static final Uri CONTENT_URI_RELATIONSHIP_JOIN_PERSON_GET_RELATIVES = Uri
            .parse("content://" + AUTHORITY + "/"
                    + PATH_RELATIONSHIP_JOIN_PERSON_GET_RELATIVES);
...
    private static final int RELATIONSHIP_JOIN_PERSON_GET_RELATIVES = 21;
private static final UriMatcher sURIMatcher = new UriMatcher(
            UriMatcher.NO_MATCH);
    static {
...
//JOINS
        sURIMatcher.addURI(AUTHORITY, PATH_RELATIONSHIP_JOIN_PERSON_GET_RELATIVES + "/#",
                RELATIONSHIP_JOIN_PERSON_GET_RELATIVES);
...

public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {

        // Uisng SQLiteQueryBuilder instead of query() method
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        // check if the caller has requested a column which does not exists
        //checkColumns(projection);

        int uriType = sURIMatcher.match(uri);

        switch (uriType) {
        ...
        case RELATIONSHIP_JOIN_PERSON_GET_RELATIVES:
            db = dbHelper.getWritableDatabase();
            String[] args = {String.valueOf(uri.getLastPathSegment())};
            Cursor cursor = db.rawQuery(
                    "SELECT p1.first_name, p1.last_name " +
                    "FROM Person p1, Person p2, Relationship r " +
                    "WHERE p1.id = r.relative_id AND " +
                    "p2.id = r.related_id AND " + 
                    "p2.id = ?", args);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            return cursor;
        ...
}