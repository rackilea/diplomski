MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
    try {
        metadataRetriever.setDataSource(path);
        String duration=metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long time=Long.valueOf(duration)/2;
        Bitmap bitmap = metadataRetriever.getFrameAtTime(time,MediaMetadataRetriever.OPTION_NEXT_SYNC);
    //now convert to base64
    } catch (Exception ex) {
    }