Bitmap image = Bitmap.createBitmap(rgba.cols(),
        rgba.rows(), Bitmap.Config.RGB_565);

Utils.matToBitmap(rgba, image);

Bitmap bitmap = (Bitmap) image;
bitmap = Bitmap.createScaledBitmap(bitmap, 600, 450, false);