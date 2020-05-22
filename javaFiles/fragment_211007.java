public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        Uri selectedImageUri = data.getData( );
        String picturePath = getPath( getActivity( ).getApplicationContext( ), selectedImageUri );
        Log.d("Picture Path", picturePath);
        upload(picturePath);

    }
}

public static String getPath( Context context, Uri uri ) {
    String result = null;
    String[] proj = { MediaStore.Images.Media.DATA };
    Cursor cursor = context.getContentResolver( ).query( uri, proj, null, null, null );
    if(cursor != null){
        if ( cursor.moveToFirst( ) ) {
            int column_index = cursor.getColumnIndexOrThrow( proj[0] );
            result = cursor.getString( column_index );
        }
        cursor.close( );
    }
    if(result == null) {
        result = "Not found";
    }
    return result;
}