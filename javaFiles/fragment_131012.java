@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if ((requestCode == FILE_SELECT_CODE) && (resultCode == RESULT_OK)) {
        Uri uri = data.getData();
        FilePath = getRealPathFromURI(uri);
    }

}


private String getRealPathFromURI(Uri uri){
    String filePath = "";
    String[] filePahColumn = {MediaStore.Images.Media.DATA};
    Cursor cursor = getContentResolver().query(uri, filePahColumn, null, null, null);
    if (cursor != null) {
        if(cursor.moveToFirst()){
            int columnIndex = cursor.getColumnIndex(filePahColumn[0]);
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
    }
    return filePath;
}