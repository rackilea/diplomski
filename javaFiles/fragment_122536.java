private File getOutputMediaFile(int type, String imgname) {
          // External sdcard location
          //public static String DIRECTORY_PICTURES = "Pictures";
          File mediaStorageDir = new File(
          Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), IMAGE_DIRECTORY_NAME);

      // Create the storage directory if it does not exist
      if (!mediaStorageDir.exists()) {
         if (!mediaStorageDir.mkdirs()) {
            Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                + IMAGE_DIRECTORY_NAME + " directory");
            return null;
         }
      }


      File mediaFile;
      if (type == MEDIA_TYPE_IMAGE) {
         mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + imgname + ".jpg");
      }  else {
         return null;
      }
      return mediaFile;
   }