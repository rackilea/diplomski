Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
intent.putExtra("return-data", false);
intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(AVATAR_FILE_TMP));
intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
intent.putExtra("noFaceDetection", true);
startActivityForResult(intent, CODE_TAKE_PHOTO);