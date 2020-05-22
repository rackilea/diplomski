@Override
 protected void onDraw(Canvas canvas) {
//super.onDraw(canvas);
    Drawable drawable = getDrawable();

    Bitmap b =  ((BitmapDrawable)drawable).getBitmap() ;
    Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

    int w = getWidth(), h = getHeight();


    Bitmap roundBitmap =  CropImageView.getRoundedCornerBitmap( getContext(), bitmap,10 , w, h , true, false,true, false);
    canvas.drawBitmap(roundBitmap, 0,0 , null);
}