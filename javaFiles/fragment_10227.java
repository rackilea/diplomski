//  Util.TEMP_PHOTO_FILE_NAME is String file name ; 

            String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            mFileTemp = new File(Environment
                    .getExternalStorageDirectory(),
                    Util.TEMP_PHOTO_FILE_NAME);
        } else {
            mFileTemp = new File(getApplicationContext().getFilesDir(),
                    Util.TEMP_PHOTO_FILE_NAME);
        }
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            Uri mImageCaptureUri = null;
            // String state = Environment.getExternalStorageState();
            if (mFileTemp == null) {
                System.out.println("no file found");
            } else {
                System.out.println("file found");

            }
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                mImageCaptureUri = Uri.fromFile(mFileTemp);
            } else {
                mImageCaptureUri = InternalStorageContentProvider.CONTENT_URI;
            }
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
                    mImageCaptureUri);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, SELECT_CAMERA_IMAGE_REQUEST);
            /*
             * Intent cameraIntent = new
             * Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
             * startActivityForResult(cameraIntent,
             * SELECT_CAMERA_IMAGE_REQUEST);
             */
        } catch (ActivityNotFoundException e) {

            Log.d("Tag", "cannot take picture", e);
        }