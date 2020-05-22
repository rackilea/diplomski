Dictionary<Tile,Tile> path = ...;
Queue<Tile> frontier = ...;
Set<Tile> explored = ...;

path[start] = null;

while(frontier.Count > 0){
    var tile = frontier.Dequeue();

    if(explored.Contains(tile)){
        continue;
    }
    explored.add(tile);

    if (Tile == Exit){
        rebuildPath(Exit);
    }else{
        for (Tile t in Tile.neighbours){
            if (!explored.Contains(t)){
                frontier.Enqueue(t);
                path[t] = tile; // Set the path hierarchy
            }
        }
    }
}