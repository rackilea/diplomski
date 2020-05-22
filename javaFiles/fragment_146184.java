protected void initImpl() {
    if (subImages != null) {
        return;
    }

    int tilesAcross = ((getWidth()-(margin*2) - tw) / (tw + spacing)) + 1;
    int tilesDown = ((getHeight()-(margin*2) - th) / (th + spacing)) + 1; 
    if ((getHeight() - th) % (th+spacing) != 0) {
        tilesDown++;
    }

    subImages = new Image[tilesAcross][tilesDown];
    for (int x=0;x<tilesAcross;x++) {
        for (int y=0;y<tilesDown;y++) {
            //extract parts of the main image and store them in an array as sprites
            subImages[x][y] = getSprite(x,y);
        }
    }
}

/**
 * Get a sprite at a particular cell on the sprite sheet
 * 
 * @param x The x position of the cell on the sprite sheet
 * @param y The y position of the cell on the sprite sheet
 * @return The single image from the sprite sheet
 */
public Image getSprite(int x, int y) {
    target.init();
    initImpl();

    if ((x < 0) || (x >= subImages.length)) {
        throw new RuntimeException("SubImage out of sheet bounds: "+x+","+y);
    }
    if ((y < 0) || (y >= subImages[0].length)) {
        throw new RuntimeException("SubImage out of sheet bounds: "+x+","+y);
    }
    //Call Image.getSubImage() to get a portion of the image
    return target.getSubImage(x*(tw+spacing) + margin, y*(th+spacing) + margin,tw,th); 
}