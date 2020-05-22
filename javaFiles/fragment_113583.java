public final void addManually(File file) {
        try{
            MediaStore.Images.Media.insertImage(mContext.getContentResolver(),
                    file.getAbsolutePath(), file.getName(), null);
            mContext.sendBroadcast(new Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.fromFile(file))
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }