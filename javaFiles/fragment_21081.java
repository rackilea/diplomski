public Uri captureImage() {
    Intent chooserIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (chooserIntent.resolveActivity(getPackageManager()) != null) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Image File name");
        Uri takenImageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent intentPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentPicture.putExtra(MediaStore.EXTRA_OUTPUT, takenImageUri);
        startActivityForResult(intentPicture, MyConstants.REQUEST_IMAGE_CAPTURE);
        return takenImageUri;
    }
    return null;
}


public String getRealPathFromURI(Uri contentUri){
    try {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    catch (Exception e){
        return contentUri.getPath();
    }
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == Activity.RESULT_OK && data != null) {
        switch (requestCode){
            case MyConstants.REQUEST_IMAGE_CAPTURE:
                if (takenImageUri != null) {
                    Uri imagePath =getRealPathFromURI(takenImageUri,this));
                }
        }
    }
}