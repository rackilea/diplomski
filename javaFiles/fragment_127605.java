void addQuestion(Question question) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_QUESTION, question.getQuestion());
    values.put(KEY_ORDER_NO, question.getorderNo());
  if (dataExists(question.getQuestionId())) {
            db.update(TABLE_QUESTION, values, KEY_QUESTION_ID + "=" + question.getQuestionId(), null);
        } else {
            db.insert(TABLE_QUESTOIN, null, values);
            db.close();
        }
}