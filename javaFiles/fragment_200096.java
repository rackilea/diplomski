public static Bitmap drawableToBitmap(Drawable drawable) {  
    int width = drawable.getIntrinsicWidth();  
    int height = drawable.getIntrinsicHeight();  
    Bitmap bitmap = Bitmap.createBitmap(width, height, drawable  
            .getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888  
            : Bitmap.Config.RGB_565);  
    Canvas canvas = new Canvas(bitmap);  
    drawable.setBounds(0, 0, width, height);  
    drawable.draw(canvas);  
    return bitmap;  
}