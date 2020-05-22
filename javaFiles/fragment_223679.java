maxHeight(tiles, currentWidth) {

    // Base case
    if (tiles.isEmpty())
        return 0;  // no tiles -> maxHeight == 0

    int h = 0;
    currentTile = tiles[0]
    remainingTiles = tiles[1...]

    // Compute maxHeight for the case when not using current tile
    h = max(h, maxHeight(remainingTiles, currentWidth)

    // Compute maxHeight when using current tile
    if (currentWidth > currentTile.width)
        subHeight = maxHeight(remainingTiles, currentTile.width)
        h = max(h, subHeight + currentTile.height)

    // Compute maxHeight when using current tile rotated
    if (currentWidth > currentTile.height)
        subHeight = maxHeight(remainingTiles, currentTile.height)
        h = max(h, subHeight + currentTile.width)

    return h
}