private class FileUploadProgressListener implements MediaHttpUploaderProgressListener {

    private String mFileUploadedName;

    public FileUploadProgressListener(String fileName) {
        mFileUploadedName = fileName;
    }

    @Override
    public void progressChanged(MediaHttpUploader mediaHttpUploader) throws IOException {
        if (mediaHttpUploader == null) return;
        switch (mediaHttpUploader.getUploadState()) {
            case INITIATION_STARTED:
            //System.out.println("Initiation has started!");
                break;
            case INITIATION_COMPLETE:
            //System.out.println("Initiation is complete!");
                break;
            case MEDIA_IN_PROGRESS:
                double percent = mediaHttpUploader.getProgress() * 100;
                if (Ln.DEBUG) {
                    Log.d(Ln.TAG, "Upload to Dropbox: " + mFileUploadedName + " - " + String.valueOf(percent) + "%");
                }
                notif.setProgress(percent, mFileUploadedName).fire();
                break;
            case MEDIA_COMPLETE:
            //System.out.println("Upload is complete!");
        }
    }
}