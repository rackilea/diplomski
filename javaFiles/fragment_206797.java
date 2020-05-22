private String checkDatabaseValue(Cursor cursor){
    String result = null;
    try{
        //This can throw an error if the column is not found
        int index = cursor.getColumnIndexOrThrow(WineContract.WineEntry.COLUMN_WINE_IMAGE);
        result = cursor.getString(index).trim();
    }
    catch(Exception ex){
        // determine what threw the error and handle appropriately
        Log.e(TAG, ex.getMessage());
    }
    return result;
}