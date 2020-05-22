public void drawRotatedScaledBitmap(Bitmap b, 
        float centerX, float centerY, float width, float height,
        float sourceX, float sourceY, 
        float sourceWidth, float sourceHeight, float angle)
{
    float cx = centerX;
    float cy = centerY;

    dstRect.left = (int)centerX - (int)(width / 2);
    dstRect.top = (int)centerY - (int)(height / 2);
    dstRect.right = dstRect.left +  (int)width;
    dstRect.bottom = dstRect.top +  (int)height;

    srcRect.left = (int)sourceX;
    srcRect.top = (int)sourceY;
    srcRect.right = srcRect.left +  (int)sourceWidth;
    srcRect.bottom = srcRect.top +  (int)sourceHeight;

    canvas.rotate(angle * (180.0f / (float)(Math.PI)),cx,cy);
    canvas.drawBitmap(b, srcRect, dstRect, null);
    canvas.rotate(-angle * (180.0f / (float)(Math.PI)),cx,cy);
}