public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // I assert equal tiling of the actual size here, otherwise you may define
    // the tile sizes as constants and calculate preferredSize as tileWidth*m_xTiles
    // and tileHeight*m_yTiles, respectively
    final int tileWidth=getWidth()/m_xTiles;
    final int tileHeight=getHeight()/m_yTiles;

    Rectangle clip = g.getClipBounds();

    int firstX, lastX, firstY, lastY;
    if(clip == null) {
        firstX=0; lastX=m_xTiles-1;
        firstY=0; lastY=m_yTiles-1;
    }
    else {
       firstX=clip.x/tileWidth;  lastX=(clip.x+clip.width)/tileWidth;
       firstY=clip.y/tileHeight; lastY=(clip.y+clip.height)/tileHeight;
    }
    // note that the loop condition is <= now to handle partially visible tiles
    for(int i = firstX; i <= lastX; i++)
    {
        for(int j = firstY; j <= lastY; j++)
        {
            m_mapTiles.get(i).get(j).DrawImage(g);
        }
    }
}