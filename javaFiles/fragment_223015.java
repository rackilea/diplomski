searchpath = "%" + yourpath + "%";// looking for path string
   ContentResolver musicResolver = mContext.getContentResolver();
  Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
  Cursor musicCursor = null;
  try {
    musicCursor = musicResolver.query(uri,
            new String[]{
                    MediaStore.Audio.Media._ID,
                    MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.TITLE,
                    MediaStore.Audio.Media.DURATION,
            },
            MediaStore.Audio.Media.DATA + "LIKE? ",
            new String[]{searchpath},
            null);
} catch (IOException e) {
    e.printStackTrace();
}