DBHandler search = new DBHandler(this, null, null);

search.open();
Cursor record = search.getData();    
//startManagingCursor(record);  
if(record.getCount()!=0){
    if(record.moveToFirst()){
        do{

        //your code here.
        }while(record.moveToNext());
    }
}   
record.close();
search.close();