public void run() {
    final int[][] points = { //I used -1 to denote non-adjacency/edges
        //0, 1, 2, 3, 4, 5, 6, 7
        {-1,20,-1,80,-1,-1,90,-1}, //0
        {-1,-1,-1,-1,-1,10,-1,-1}, //1
        {-1,-1,-1,10,-1,50,-1,20}, //2
        {-1,-1,-1,-1,-1,-1,20,-1}, //3
        {-1,50,-1,-1,-1,-1,30,-1}, //4
        {-1,-1,10,40,-1,-1,-1,-1}, //5
        {-1,-1,-1,-1,-1,-1,-1,-1}, //6
        {-1,-1,-1,-1,-1,-1,-1,-1}  //7
    };
    final int[] result = dijkstra(points,0);
    System.out.print("Result:");
    for(final int i : result) {
        System.out.print(" " + i);
    }
}

public int[] dijkstra(final int[][] points,final int startingPoint) {
    final int[] record = new int[points.length]; //Keeps track of the distance from start to each vertex.
    final boolean[] explored = new boolean[points.length]; //Keeps track of whether we have completely explored every vertex.
    Arrays.fill(record,Integer.MAX_VALUE);
    final PriorityQueue<VertexAndDistance> todo = new PriorityQueue<>(points.length); //Vertices left to traverse.
    todo.add(new VertexAndDistance(startingPoint,0)); //Starting point (and distance 0).
    record[startingPoint] = 0; //We already know that the distance to the starting point is 0.
    while(!todo.isEmpty()) { //Continue until we have nothing left to do.
        final VertexAndDistance next = todo.poll(); //Take the next closest vertex.
        final int q1 = next.vertex;
        if(explored[q1]) { //We have already done this one, don't do it again.
            continue; //...with the next vertex.
        }

        for(int q2 = 1;q2 < points.length;q2++) { //Find connected vertices.
            if(points[q1][q2] != -1) { //If the vertices are connected by an edge.
                final int distance = record[q1] + points[q1][q2];
                if(distance < record[q2]) { //And it is closer than we've seen so far.
                    record[q2] = distance;
                    todo.add(new VertexAndDistance(q2,distance)); //Explore it later.
                }
            }
        }

        explored[q1] = true; //We're done with this vertex now.
    }
    return record;
}

private class VertexAndDistance implements Comparable<VertexAndDistance> {
    private final int distance;
    private final int vertex;

    private VertexAndDistance(final int vertex,final int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    /**
     * Compares two {@code VertexAndDistance} instances by their distance.
     * @param other The instance with which to compare this instance.
     * @return A positive integer if this distance is more than the distance
     * of the specified object, a negative integer if it is less, or
     * {@code 0} if they are equal.
     */
    @Override
    public int compareTo(final VertexAndDistance other) {
        return Integer.compare(distance,other.distance);
    }
}