Cursor cursor = db.query(TaskContract.Entry.TABLE,
            new String[]{TaskContract.Entry._ID,
                    TaskContract.Entry.COL_TITLE,
                    TaskContract.Entry.COL_MAX,
                    TaskContract.Entry.COL_INCREMENT},
            TaskContract.Entry._ID + " = ?",
            new String[]{String.valueOf(id)},
            null, null, null);