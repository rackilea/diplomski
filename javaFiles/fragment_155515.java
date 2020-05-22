String checkedValue = cursor.getString(1);

while(cursor.moveToNext()){
    String value = cursor.getString(1);
    if(value.equals(checkedValue)){ 
        // TODO: duplicate value found, do something
        break;
    }
}