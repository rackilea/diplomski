Uri album_uri = getAlbumUri(mContext,album_id);

    if(album_uri!=null ) {
        Glide.with(mContext)
                .asBitmap()
                .load(album_uri)
                .into(holder.image);
    }


     public Uri getAlbumUri(Context mContext,String album_id){
    if(mContext!=null) {
        Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
        Uri imageUri = Uri.withAppendedPath(sArtworkUri, String.valueOf(album_id));
        return imageUri;
    }
    return null;
}