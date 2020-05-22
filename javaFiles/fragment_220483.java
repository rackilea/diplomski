Try this code.


private Uri getOutputMediaFile() {

        File mediaStorageDir = new File(
                Environment.getExternalStorageDirectory(), ".camerapics");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;

        mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");
        Uri uri = null;
        if (mediaFile != null) {
            uri = Uri.fromFile(mediaFile);

        }
        return uri;
    }


    mtestImage = (ImageView) findViewById(R.id.testImage);
mtestImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        fileUri = getOutputMediaFile();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });


        public void onActivityResult(int reqCode, int resCode, Intent data)
{
if (resCode == RESULT_OK) {
          if (reqCode == RESULT_LOAD_IMAGE) {
            Bitmap bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(fileUri));
            mtestImage.setImageBitmap(bmp);