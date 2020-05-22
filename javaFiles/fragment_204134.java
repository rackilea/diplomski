public List<Video> getFilesKitkat(){
    int i = 0;
    list.clear();//list is global

    //App package directory in the sd card to get all the files,
    // in my case, there is only mp4 files.
    // /storage/extSdCard/Android/data/<package_name>/files...
    File targetDirector = new File (videosPath);

    File[] files = targetDirector.listFiles();
    int totalFiles = files.length;
    String[] filesToScan = new String[totalFiles];

    //this is to get all the paths in order to pass them to MediaScannerConnection
    for (File file : files){    
        filesToScan[i] = file.getAbsolutePath();
        i++;
    }
    callMediaScanner_kitkat(filesToScan);

    return list;
}

public void callMediaScanner_kitkat(final String[] files) {
    MediaScannerConnection.scanFile(context, files, null, 
            new MediaScannerConnection.OnScanCompletedListener() {
        @Override
        public void onScanCompleted(String path, Uri uri) {
            // TODO Auto-generated method stub
            Log.i("Test", "Scanned " + path);
            getVideosList_kitkat(context, uri);
        }
    });
}

public void getVideosList_kitkat(Context context, Uri contentUri) {
      Cursor cursor = null;
      try { 
          String[] proj = { MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.DISPLAY_NAME,
                MediaStore.Video.Media.SIZE, 
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.DATE_MODIFIED};
        cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);

        while (cursor.moveToNext()){
              Video video = new Video();

              int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
              int id = cursor.getInt(cursor.getColumnIndex(MediaStore.Video.Media._ID));
              String nombre = (cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))).toLowerCase();
              video.setName(nombre + XSalesApplication.getActivityContext().getResources().getString(R.string.video_extension));
              video.setId(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID)));
              video.setSize(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE)));
              video.setUrlMedia(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)));      video.setlastModified(cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED)));

              Bitmap bmThumbnail = ThumbnailUtils.createVideoThumbnail(video.getUrlMedia(), Thumbnails.MICRO_KIND);
              video.setPhotoBitmap(bmThumbnail);

              list.add(video);
        }

      } finally {
        if (cursor != null) {
          cursor.close();
        }
      }
    }