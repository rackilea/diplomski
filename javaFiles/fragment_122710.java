//---scales the alertdialog items to the right size---
    Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(), R.drawable.tick); 
    int width = bitmapOrg.getWidth(); 
    int height = bitmapOrg.getHeight(); 
    int newWidth = 200; 
    int newHeight = 200;

    // calculate the scale - in this case = 0.4f 
    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height; 

    // create matrix for the manipulation
    Matrix matrix = new Matrix();  

    // resize the bit map
    matrix.postScale(scaleWidth, scaleHeight);

    // rotate the Bitmap
    matrix.postRotate(0);  

    // recreate the new Bitmap 
    Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height, matrix, true);   

    // make a Drawable from Bitmap to allow to set the BitMap  // to the ImageView, ImageButton or what ever 
    BitmapDrawable bmd = new BitmapDrawable(resizedBitmap);