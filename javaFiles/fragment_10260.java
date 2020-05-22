AssetFileDescriptor fd = null;
    try {
        ContentResolver resolver = context.getContentResolver();
        fd = resolver.openAssetFileDescriptor(uri, "r");
        //  :
        //  :
        //  :
        if (fd.getDeclaredLength() < 0) {
                setDataSource(fd.getFileDescriptor());
            } else {
                setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getDeclaredLength());
            }