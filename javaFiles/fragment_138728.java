// Note: The function neighbors(x) returns the list of neighbors of node x
// The function distance(x, y) returns distance between node x and y
// applying dijkstra algorithm

shortestDistance = 0;
for (Node neighbor : neighbors(x)) {
   currentDistance = distance(x, neighbor) + distance(neighbor, x);
   shortestDistance = min(currentDistance, shortestDistance);
}
return shortestDistance;