exploreNeighbor( q, -1, 0);  // left
exploreNeighbor( q, +1, 0);  // right
exploreNeighbor( q, 0, -1);  // up
exploreNeighbor( q, 0, +1);  // down

protected boolean exploreNeighbor (Node parent, int offsetX, int offsetY) {
    int x = q.getX() + offsetX;
    int y = q.getY() + offsetY;
    if (x < 0 || x >= screen.map.width)
        return null;
    if (y < 0 || y >= screen.map.height)
        return false;
    int content = screen.map.mapArray[x][y];
    if (content == Contents.CANTMOVEONPOSITION ||
            content == Contents.MONSTERSTATE) {
        return false;
    }

    // represent Neighbor Position;
    //  
    Node n = new Node(parent, x, y);
    n.g = calcG(n);
    n.h = calcH(n, (int) this.screen.character.mapPos.x,
            (int) this.screen.character.mapPos.y);

    // check if Discovered yet;
    //
    if (discoveredSet.contains( n)) {
        // already queued or visited.
        return false;
    }

    // queue it for exploration.
    openQueue.add( n);
    return true;
}