@Override
public void progressChanged(MediaHttpUploader uploader) {
    String sizeTemp = "Uploading"
            + ": "
            + Formatter.formatShortFileSize(this, uploader.getNumBytesUploaded())
            + "/"
            + Formatter.formatShortFileSize(this, totalFileSize);
    runOnUiThread(() -> textView.setText(sizeTemp));
}