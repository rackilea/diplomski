Display display = getWindowManager().getDefaultDisplay();
 DisplayMetrics outMetrics = new DisplayMetrics ();
 display.getMetrics(outMetrics);

 float density  = getResources().getDisplayMetrics().density;
 float dpHeight = outMetrics.heightPixels / density;
 float dpWidth  = outMetrics.widthPixels / density;