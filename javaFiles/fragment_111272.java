public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        if (requestCode == SELECT_PICTURE) {

            Uri selectedImageUri = data.getData();
            String s1 = data.getDataString();
            //String s1 = selectedImageUri.getPath();
            Log.e("GetPath",s1);
            //s1 = s1.replaceAll("file://","");
            //Uri a = Uri.fromParts(s1,null,null);
            Log.e("OK",""+selectedImageUri);
            //Log.e("A",""+a);

            selectedImagePath = getPath(selectedImageUri);
            if(selectedImagePath==null && s1 != null)
            {
                selectedImagePath = s1.replaceAll("file://","");
            }
        //  selectedImagePath = getPath(a);




            Intent intent = new Intent(this, PhotoEditorActivity.class);
            intent.putExtra("path", selectedImagePath);
            startActivity(intent);
            finish();


        }
                  }
               }


///////////////////////////////////
   public String getPath(Uri uri) {

    try{
    String[] projection = { MediaStore.Images.Media.DATA };
    Log.e("OK 1",""+projection);
    Cursor cursor = managedQuery(uri, projection, null, null, null);
    Log.e("OK 2",""+cursor);
    if(cursor==null)
    {
        return null;

    }
    int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
    Log.e("OK 3",""+column_index);
    cursor.moveToFirst();
    Log.e("OK 4",""+cursor.getString(column_index));
    return cursor.getString(column_index);
    }
    catch(Exception e)
    {
        Toast.makeText(PhotoActivity.this, "Image is too big in resolution please try again", 5).show();
        return null;
    }

}