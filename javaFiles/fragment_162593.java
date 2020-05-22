public String[] getClasses() {
    String[] columns = {KEY_NAME};
    Cursor c = db.query(DATABASE_TABLE, columns, null, null, null, null, null);
    String[] classes = new String [c.getCount()];
    int i = 0;
    while (c.moveToNext()) {
        classes[i] = c.getString(0);
        i++;
    }
    c.close();
    return classes; 
}