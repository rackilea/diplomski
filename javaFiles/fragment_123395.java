/**
 * Gets the Amount of Degress of rotation using the exif integer to determine how much
 * we should rotate the image.
 * @param exifOrientation - the Exif data for Image Orientation
 * @return - how much to rotate in degress
 */
private static int exifToDegrees(int exifOrientation) {
    if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) { return 90; }
    else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {  return 180; }
    else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {  return 270; }
    return 0;
}