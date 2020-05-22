public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final int RESULT_LOAD_IMAGE = 10;
     private Bitmap myBitmap;
     ImageView myImage ;
        public void OpenCam(View view) {

              Intent takePictureIntent = new             Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if     (takePictureIntent.resolveActivity(getPackageManager()) != null) 
                    {

                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
    }