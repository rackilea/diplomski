public void writeDisplayPhoto(long rawContactId, byte[] photo) {
    Uri rawContactPhotoUri = Uri.withAppendedPath(
            ContentUris.withAppendedId(RawContacts.CONTENT_URI, rawContactId),
            RawContacts.DisplayPhoto.CONTENT_DIRECTORY);
    try {
        AssetFileDescriptor fd =
            getContentResolver().openAssetFileDescriptor(rawContactPhotoUri, "rw");
        OutputStream os = fd.createOutputStream();
        os.write(photo);
        os.close();
        fd.close();
    } catch (IOException e) {
        // Handle error cases.
    }
}