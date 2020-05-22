if(cursor != null) {
    while(cursor.moveToNext()) {
        id = cursor.getString(0);
    }
} else {
    id = "";
}