public void deleteTask(long id) {

    //TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
    //String task = String.valueOf(taskTextView.getText());
    SQLiteDatabase db = mHelper.getWritableDatabase();
    db.delete(TaskContract.TaskEntry.TABLE, TaskContract.TaskEntry._ID + " = ?", new String[]{String.valueOf(id)});
    db.close();
    updateUI();
}