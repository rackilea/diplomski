1.  @Override
        public void onCameraOpen() {
          Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (pictureIntent.resolveActivity(getPackageManager()) != null) {
                try {
                    imageFile = CameraUtils.createImageFile(this);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                imageUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", imageFile);
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(pictureIntent, IntentRequestCode.RESULT_CODE_IMAGE_CAPTURE);
            }
        }

2.  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_CODE_IMAGE_CAPTURE:
                if (resultCode == RESULT_OK) {
                    onCaptureImage(imageFile, imageUri);
                } else {
                    Toast.makeText(this, "Camera canceled", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

3. void onCaptureImage(File imageFile, Uri imageUri) {
        Uri uri = Uri.fromFile(imageFile);
        String selectedImagePath = CameraUtils.getPath(application, uri);
        File file1 = new File(selectedImagePath);
        if (file1.length() != 0) {
           FileAttachments b_data = new FileAttachments();
            b_data.setFileName(file1.getName());
            CameraUtils.writeScaledDownImage(file1, getApplication());
            b_data.setFile(file1);
        }
    }