for (x=0; x<= width / tileWidth; x++)
    {
            for (y=0; y<= height / tileHeight ; y++)
            {
                    g.drawImage(tile, x * tileWidth, y * tileHeight, this);
            }
    }