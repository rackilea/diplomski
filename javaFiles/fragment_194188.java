private void dispatchTakePictureIntent() { 
    final CharSequence[] options = {"Take Photo", "Choose Photo", "Cancel"};
    final AlertDialog.Builder cameraChoice = new AlertDialog.Builder(Person2Screen.this);
    cameraChoice.setTitle("Take/choose new photo");
    cameraChoice.setItems(options, new DialogInterface.OnClickListener() {
        @Override 
        public void onClick(DialogInterface dialog, int which) {
            if (options[which].equals("Cancel")) {
                dialog.dismiss();
            } else {
                Intent intent;
                int requestCode;

                if (options[which].equals("Take Photo")) {
                     intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                } else { // from doc
                     intent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }

                switch (id) {
                     case HAPPY_ID2:
                         requestCode = REQUEST_HAPPY_PHOTO;
                         break;
                     case SURPRISED_ID2:
                         requestCode = REQUEST_SURPRISED_PHOTO;
                         break;
                     case AFRAID_ID2:
                         requestCode = REQUEST_AFRAID_PHOTO;
                         break;
                     case UPSET_ID2:
                         requestCode = REQUEST_UPSET_PHOTO;
                         break;
                     default:
                         requestCode = REQUEST_SAD_PHOTO;
                         break;
                }

                startActivityForResult(intent, requestCode);
            }
        } 
    });