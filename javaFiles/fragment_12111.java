public static Bitmap getFooterBitmap(int width, int height){ 
    Bitmap bm = Bitmap.getBitmapResource(width+"x"+height+"/footer_bp.png);
    if (bm == null)
       bm = Bitmap.getBitmapResource("320x240/footer_bp.png);
    return bm;
}