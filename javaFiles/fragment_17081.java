Cursor countCursor = getContentResolver().query(CONTENT_URI,
                "count(*) AS count",
                null,
                null,
                null);

        countCursor.moveToFirst();
        int count = countCursor.getInt(0);