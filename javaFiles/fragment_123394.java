File curFile = new File("path-to-file"); // ... This is an image file from my device.
    Bitmap rotatedBitmap;

            try {
                ExifInterface exif = new ExifInterface(curFile.getPath());
                int rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                int rotationInDegrees = exifToDegrees(rotation);
                Matrix matrix = new Matrix();
                if (rotation != 0f) {matrix.preRotate(rotationInDegrees);}
                rotatedBitmap = Bitmap.createBitmap(bitmap,0,0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);


            }catch(IOException ex){
                Log.e(TAG, "Failed to get Exif data", ex);
            }