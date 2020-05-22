if(cursor.getCount() != 0) {
    while(cursor.moveToNext()){
        int id = cursor.getInt(cursor.getColumnIndex(room.Col_Id));
        String name = cursor.getString(cursor.getColumnIndex(room.Col_Name));
        String type = cursor.getString(cursor.getColumnIndex(room.Col_Type));
        String price = cursor.getString(cursor.getColumnIndex(room.Col_Price));
        room r = new room(id, name, type, price);
        rooms.add(r);
    }
}