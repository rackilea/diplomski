File imageFile = new 
File(Environment.getExternalStorageDirectory(),"fname_" 
+ ".jpg");
mSavedPath = imageFile.getAbsolutePath();
imageUri = Uri.fromFile(imageFile);
          intent.putExtra(
android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, 
CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);