public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notesDB";
    private static final String TABLE_NAME = "notes";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT," + KEY_DESCRIPTION + " TEXT)";
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void AddNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(KEY_NAME, note.getNoteName());
        value.put(KEY_DESCRIPTION, note.getNoteDescription());

        db.insert(TABLE_NAME, null, value);
        db.close();
    }

    Note getNote(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_DESCRIPTION}, KEY_ID
                + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Note note = new Note(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        return note;
    }

    public ArrayList<Note> getAllNotes(){
        ArrayList<Note> noteList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Note note = new Note();
                note.setID(Integer.parseInt(cursor.getString(0)));
                note.setNoteName(cursor.getString(1));
                note.setNoteDescription(cursor.getString(2));

                noteList.add(note);
            } while(cursor.moveToNext());

        } cursor.close();

        return noteList;
    }

    public int updateNotes(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, note.getNoteName());
        values.put(KEY_DESCRIPTION, note.getNoteDescription());

        return db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(note.getID())});
    }

    public void deleteNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{String.valueOf(note.getID())});
        db.close();
    }

    public int getNoteCount(Note note){
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();


        return cursor.getCount();
    }
}