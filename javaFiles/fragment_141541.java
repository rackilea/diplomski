Storage storage = null;
try {
    // ...
    if (storage == null) {
        storage = new Storage(new Record(j, Integer.parseInt(ContentCount), RowContent));
    } else {
        storage.addRecord(j, Integer.parseInt(ContentCount), RowContent));
    }
} catch (...) {
    // ...
}