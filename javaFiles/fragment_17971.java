trapViews extends View{
    Bitmap image;
        Bitmap resizedBitmap;


        //rechte Seite
       Bitmap images ;
        Bitmap resizedBitmaps;

trapViews(Context c){
image = BitmapFactory.decodeResource(getResources(), R.drawable.stachelnstart);
images = BitmapFactory.decodeResource(getResources(), R.drawable.stachelnstart1);

}

@Override
protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = 20;
        Random r = new Random();
        int i1 = r.nextInt(900 - 200) + 200;
        rnd = new Random();
        //Linke Seite
          //I have left this bitmap in the here as it is affected by the random int
         resizedBitmap = Bitmap.createScaledBitmap(image, i1, 300, true);
            float left = (float) 0;
            float top = (float) (getHeight() - resizedBitmap.getHeight());
            canvas.drawBitmap(resizedBitmap, left, top, paint);

          //create this bitmap here as getWidth() will return 0 if created in the view's constructor
        if(resizedBitmaps == null)
         resizedBitmaps = Bitmap.createScaledBitmap(images, getWidth()-resizedBitmap.getWidth()-OwlHole, 300, true);
            float left1 = (float) (getWidth() - resizedBitmaps.getWidth());
            float top1 = (float) (getHeight() - resizedBitmaps.getHeight());
            canvas.drawBitmap(resizedBitmaps, left1, top1, paint);

}


}