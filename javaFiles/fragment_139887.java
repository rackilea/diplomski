final Cursor data = readingListDB.getData();
    while (data.moveToNext()) {
        ReadingList list = new ReadingList();
        // add proper column name.
        String pageTitle = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
        String pageUrl = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
        // I am assuming the method name here, add your own method names.
        list.setPageTitle(pageTitle);
        list.setPageUrl(pageUrl);
        arrayList.add(list);

        Log.d("TAG", "onCreateView: " + data + list);

    }