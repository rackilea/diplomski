String one, two, three;

listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        cursor.moveToPosition(position);
        one = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_1));
        two = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2));
        // Etc...
    }
};