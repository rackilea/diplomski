public void refreshBitmapShader() {        
    int left = 0; y = 0; w = image.getWidth(), h = image.getHeight(); 
    // decide whether we have to crop the sizes or the top and bottom:
    if(w > h)  // width is greater than height
    {
        x = (w - h) >> 1;   // crop sides, half on each side
        w = h;
    }
    else
    {
        y = (h - w) >> 1;   // crop top and bottom
        h = w;
    }
    Matrix m = new Matrix();
    float scale = (float)canvasSize / (float)w;
    m.preScale(scale, scale);   // scale to canvas size
    shader = new BitmapShader(Bitmap.createBitmap(image, x, y, w, h, m, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
}