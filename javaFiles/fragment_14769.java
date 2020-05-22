SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
        this,
        R.layout.task_view,
        cursor,
        new String[] { TaskContract.Columns.TASK},
        new int[] { R.id.taskTextView},
        0
);