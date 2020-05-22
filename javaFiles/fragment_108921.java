onDrawFrame(GL10 gl) {
    ...

    int[] crop = new int[4];
    crop[0] = tileWidth * tileIndex;  // tileIndex represents the nth tile in the texture atlas
    crop[1] = tileHeight;
    crop[2] = tileWidth;
    crop[3] = -tileHeight;

    // specify the source rectangle 
    ((GL11) gl).glTexParameteriv(GL10.GL_TEXTURE_2D, GL11Ext.GL_TEXTURE_CROP_RECT_OES, crop, 0);

    // draw the texture
    ((GL11Ext)gl).glDrawTexiOES(x, y, 0, tileWidth, tileHeight);

    ...
}