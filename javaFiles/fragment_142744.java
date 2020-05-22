if (bitmap==null){
        Log.d(TAG, "No image was taken for wine: " + wineName);
        wineThumbnail.setImageBitmap(null);
    }else {
        Bitmap image = BitmapFactory.decodeByteArray(bitmap, 0, bitmap.length);
        wineThumbnail.setImageBitmap(image);
    }