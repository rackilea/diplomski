public Bitmap getAlbumart(Long album_id) 
   {
        Bitmap bm = null;
        try 
        {
            final Uri sArtworkUri = Uri
                .parse("content://media/external/audio/albumart");

            Uri uri = ContentUris.withAppendedId(sArtworkUri, album_id);

            ParcelFileDescriptor pfd = context.getContentResolver()
                .openFileDescriptor(uri, "r");

            if (pfd != null) 
            {
                FileDescriptor fd = pfd.getFileDescriptor();
                bm = BitmapFactory.decodeFileDescriptor(fd);
            }
    } catch (Exception e) {
    }
    return bm;
}