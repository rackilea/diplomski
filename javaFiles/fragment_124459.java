SQLiteDatabase database = this.getWritableDatabase();
String whichPlayer = "somePlayer";
int newScore = 4500;
// Select current player's previous score
Cursor cursor = database.rawQuery("SELECT score FROM highScore WHERE whichPlayer = ?", new String[] { whichPlayer });
if (cursor != null && cursor.getCount() != 0) {
    // We have score in database for this player
    cursor.moveToFirst();
    // Get score for this player
    int score = cursor.getInt(cursor.getColumnIndex("score"));
    // Check if your new score is higher
    if (newScore > score) {
        // update your score with new one
    }
} else {
    // There is no score stored for this player - insert if you want
}