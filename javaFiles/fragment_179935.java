if (aabb.width != Tile.SIZE) {
    aabbPool.add(aabb);
} else {
    addToMap(xCoord,yCoord);
}
aabb = null;