try {
    DbHelper dbHelper = new DbHelper();
    dbHelper.add("john", "password", "John Doe");
    dbHelper.add("mary", "password", "Mary Doe");
} catch (RecordStoreException e) {
    e.printStackTrace();
}