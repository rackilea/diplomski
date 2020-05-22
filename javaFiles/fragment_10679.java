private static final String[] VIDEOTHUMBNAIL_TABLE = new String[] {
    Video.Media._ID, // 0
    Video.Media.DATA, // 1 from android.provider.MediaStore.Video
    };

Uri videoUri = MediaStore.Video.Thumbnails.getContentUri("external");

cursor c = cr.query(videoUri, VIDEOTHUMBNAIL_TABLE, where, 
           new String[] {filepath}, null);

if ((c != null) && c.moveToFirst()) {
  VideoThumbnailPath = c.getString(1);
}