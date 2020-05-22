private void updateUI() {

ArrayList<String> taskList = new ArrayList<>();
SQLiteDatabase db = mHelper.getReadableDatabase();
Cursor cursor = db.query(InputContract.TaskEntry.TABLE,
        new String[]{InputContract.TaskEntry._ID, InputContract.TaskEntry.COL_TASK_TITLE},
        null, null, null, null, null);
while (cursor.moveToNext()) {
    int idx = cursor.getColumnIndex(InputContract.TaskEntry.COL_TASK_TITLE);
    taskList.add(cursor.getString(idx));
}

if (adapter== null) {
    adapter= new ArrayAdapter<>(this,  android.R.layout.simple_expandable_list_item_1,
            taskList);
    lv.setAdapter(adapter);
} else {
    adapter.clear();
    adapter.addAll(taskList);
    adapter.notifyDataSetChanged();
}

cursor.close();
db.close();
}