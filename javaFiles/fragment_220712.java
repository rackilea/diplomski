if ( cursor != null && cursor.getCount() > 0 ) { 
    totalRows = cursor.getCount();
if(cursor.moveToFirst()) {
    while (cursor.isAfterLast() == false) {
        if(cursor.getColumnCount() > 0) {
               ...