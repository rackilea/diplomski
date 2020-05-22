public void deleteTask() {
SQLiteDatabase db = mHelper.getWritableDatabase();
db.delete(InputContract.TaskEntry.TABLE,
        InputContract.TaskEntry.COL_TASK_TITLE + " = ?",
        new String[]{"Name of entry you want deleted"});
db.close();
updateUI();