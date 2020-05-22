mBitmap = BitmapFactory.decodeResource(getResources(),
                       R.drawable.forme).copy(Bitmap.Config.ARGB_8888, true);
this.path = new Path();

// Get the screen dimension
DisplayMetrics displaymetrics = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
h = displaymetrics.heightPixels;
w = displaymetrics.widthPixels;

scaledBitmap = Bitmap.createScaledBitmap(mBitmap, w, h, false);