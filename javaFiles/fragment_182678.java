//comapre objects returns false
        Log.i("EQ", (imageList.get(0).getDrawable().equals(imageList.get(1).getDrawable())) + "");
        Log.i("EQ", imageList.get(0).getDrawable().toString()); //android.graphics.drawable.BitmapDrawable@89c323c
        Log.i("EQ", imageList.get(1).getDrawable().toString()); //android.graphics.drawable.BitmapDrawable@837dbc5

        BitmapDrawable bitmapDrawable0 = ((BitmapDrawable) imageList.get(0).getDrawable());
        Bitmap bitmap0 = bitmapDrawable0 .getBitmap();

        BitmapDrawable bitmapDrawable1 = ((BitmapDrawable) imageList.get(1).getDrawable());
        Bitmap bitmap1 = bitmapDrawable1 .getBitmap();

        //comapre the image returns true
        Log.i("EQ2", Boolean.toString(bitmap0.sameAs(bitmap1)));