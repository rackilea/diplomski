int isUpdated = db.update(myDb.TABLE_NAME, contentValues , "ID = '"+ thisID +"'", null);// solution

if (isUpdated > 0){
    Toast.makeText(editActivity.this, "Edit Done!", Toast.LENGTH_SHORT).show();
    return true;
}else{
    Toast.makeText(editActivity.this, "Edit failed!", Toast.LENGTH_SHORT).show();
    return false;
}