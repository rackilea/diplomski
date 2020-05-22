File photoFile = null;     

mUploadBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
  if (intent.resolveActivity(getPackageManager()) != null) {  

        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            // Error occurred while creating the File
            ex.printStackTrace();
        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(photoFile));
            startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
           }
         }
     });
}

private File createImageFile() throws IOException {
    // Create an image mSelectedFile name
    String timeStamp = new SimpleDateFormat(Constants.PHOTO_DATE_FORMAT, Locale.ENGLISH).format(new Date());
    String imageFileName = "IMG_" + timeStamp;
    File storageDir = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES);
    File file = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */
    );


    return file;
}