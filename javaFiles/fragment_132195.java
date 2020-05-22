while (!openList.isEmpty()) {
    Pair node = openList.dequeueMin().getValue();

    if (node.equals(goal)) {
        // construct the path from start to goal
        return reconstruct_path(goal);
    }

    for (Pair neighborNode : getNeighbors(node,goal)) {
        if (neighborNode == null) continue;
        boolean isOpen = openSet.contains(neighborNode);
        boolean isClosed = closedSet.contains(neighborNode);
        double costFromStart = g_score[node.x][node.y]+MOVEMENT_COST;

        // check if the neighbor node has not been
        // traversed or if a shorter path to this
        // neighbor node is found.
        if (
            (!isOpen && !isClosed) // first time node has been encountered
                || //or
            costFromStart < g_score[neighborNode.x][neighborNode.y]) //new path is more efficient
        {
            came_from[neighborNode.x][neighborNode.y] = node;
            g_score[neighborNode.x][neighborNode.y] = costFromStart;
            h_score[neighborNode.x][neighborNode.y] =
                    estimateCost(neighborNode,goal);
            if (isClosed) {
                closedSet.remove(neighborNode);
            }
            if (!isOpen) {
                openList.enqueue(neighborNode,costFromStart);
                openSet.add(neighborNode);
            }
        }
    }
    closedSet.add(node);
}