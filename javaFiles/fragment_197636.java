public void incrment(View view) {
    View parent = (View) view.getParent();
    TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
    String task = taskTextView.getText().toString();
    SQLiteDatabase db = mHelper.getWritableDatabase();
    db.execSQL(
        "update " + TaskContract.TaskEntry.TABLE +
        " set " + COL_TaskContract.TaskEntry.COL_NUM + " = coalesce(" + COL_TaskContract.TaskEntry.COL_NUM + ", 0) + 1" +
        " where " + TaskContract.TaskEntry.COL_TASK_TITLE + " = ?", new Object[] {task}
    );
    db.close();
    updateUI();
}