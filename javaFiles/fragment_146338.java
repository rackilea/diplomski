/**
 * Get the uri of the captured file
 * @return A Uri which path is the path of an image file, stored on the dcim folder
 */
private Uri getImageUri() {
    // Store image in dcim
    // Here you can change yourinternal storage path to store those images..
    File file = new File(Environment.getExternalStorageDirectory() + "/DCIM", CAPTURE_TITLE);
    Uri imgUri = Uri.fromFile(file);

    return imgUri;
}