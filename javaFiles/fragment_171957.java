// code here...
if(at.isSolid()) continue;

if (Math.abs(xi * yi) == 1) {
  // this is true if we're checking diagonal tile
  if ( !isPassable(getTile(x + xi, y)) && !isPassable(getTile(x, y + yi))  {
    // Both common neigbors are not passable
    // So we won't add this tile as neighbor
    continue;
  }
}