if (cursor != null){
    cursor.moveToFirst();
    String strings[] = new String[3];
    strings[0] = cursor.getString(0);
    strings[1] = cursor.getString(1);
    strings[2] = cursor.getString(2);
    return strings;