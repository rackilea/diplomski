String type = null;
    String extension = "mp3";

    type = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

    Log.d(TAG,"mime type1 "+type);

    extension = "MP3";

    type = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

    Log.d(TAG,"mime type2 "+type);