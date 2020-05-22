private void insertDB() {
    for(int i = 0; i < listA.size(); i++) {
        int check = dbPF.createPF(listA.get(i));
    }
}

public int createPF(MyObject item) {
    ContentValues initialValues = createContentValuesPF(item);
    return (int) database.insert(tableA, null, initialValues);
}

private ContentValues creaContentValuesPod(MyObject item) {
    ContentValues values = new ContentValues();
    if (item != null) {
        values.put(key1, item.getA());
        values.put(key2, item.getB());
        values.put(key3, item.getC());
        values.put(key4, item.getD());
    } else {
        values.putNull(key1); // or whatever value(s) you want
    }
    return values;
}