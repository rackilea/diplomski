try{
    db.insertOrThrow(userTable, null, cv);
}
catch(SQLiteConstraintException ex){
//what ever you want to do
}