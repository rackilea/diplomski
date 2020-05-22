private void checkPermission(){
    if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {        
        createFile();
    } else {    
        Log.v(TAG,"Permission is revoked");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);  
    }
}


@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {
        case 0:
            boolean permissionsGranted = true;
            if (grantResults.length > 0 && permissions.length==grantResults.length) {
                for (int i = 0; i < permissions.length; i++){
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        permissionsGranted=false;
                    }
                }

            } else {
                permissionsGranted=false;
            }
            if(permissionsGranted){
                createFile();
            }
            break;
    }
}

private void createFile(){
   ContentResolver cr = this.getContentResolver();
   Bitmap bitmap;
   try{
       bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, mImageUri);
       mProfileImage.setImageBitmap(bitmap);
       saveToFirebase(bitmap);
   }catch (Exception e){
     Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT).show();
     Log.d("DebugMySocks", "Failed to load", e);
   }
}

public void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d("DebugMySocks", "onActivityResult in EditProfileActivity");
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == this.RESULT_OK) {
        this.getContentResolver().notifyChange(mImageUri, null); // <-- THIS IS LINE 254!
        checkPermission();
    }
}