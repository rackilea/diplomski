public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {  
    int width = bitmap.getWidth();  
    int height = bitmap.getHeight();  
    Matrix matrix = new Matrix();  
    float scaleWidht = ((float) w / width);  
    float scaleHeight = ((float) h / height);  
    matrix.postScale(scaleWidht, scaleHeight);  
    Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height,  
            matrix, true);  
    return newbmp;  
}