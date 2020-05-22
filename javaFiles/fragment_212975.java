Uri newPhotoUri;
public void takePhoto() {
    // create Intent to take a picture and return control to the calling application
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    newPhotoUri = Uri.fromFile(new File(filename)); // create a file to save the image
    intent.putExtra(MediaStore.EXTRA_OUTPUT, newPhotoUri); // set the image file name

    // start the image capture Intent
    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
}