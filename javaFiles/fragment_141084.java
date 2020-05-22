BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile( filename, options );
        options.inJustDecodeBounds = false;
        options.inSampleSize = 4; 

        bitmap = BitmapFactory.decodeFile( filename, options );
        if ( bitmap != null ) {
            bitmap = Bitmap.createScaledBitmap( bitmap, width, height, false );
        }