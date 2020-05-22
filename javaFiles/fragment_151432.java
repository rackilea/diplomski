while (cursor.moveToNext()) {
        int title = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
        int _id = cursor.getColumnIndex(TaskContract.TaskEntry._ID);

        Tasks tasks = new Tasks();
        tasks.setId(cursor.getInt(_id));
        tasks.setTitle(cursor.getString(title));
        taskList.add(tasks);

    }