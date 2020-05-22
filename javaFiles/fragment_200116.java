ExifInterface exifInterface = new ExifInterface(mFile.getPath());
int orientation = exifInterface.getAttributeInt(TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);
Matrix matrix = new Matrix();
switch (orientation) {
    case ExifInterface.ORIENTATION_ROTATE_90:
        matrix.postRotate(90);
        break;
    case ExifInterface.ORIENTATION_ROTATE_180:
        matrix.postRotate(180);
        break;
    case ExifInterface.ORIENTATION_ROTATE_270:
        matrix.postRotate(270);
        break;
    default:
        break;
}