LinkedList<Tile> finalPath = ...;

Tile parent = path[exitTile];
finalPath.push(exitTile);

while(parent != null){
    finalPath.push(parent);
    parent = path[parent];
}

finalPath.reverse();