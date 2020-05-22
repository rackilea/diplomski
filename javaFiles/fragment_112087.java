/*
 * The Node class creates individual elements that populate the 
 * List class. Contains indexes of the node's neighbors and their
 * respective edge weights
 */
class Node {
    public int top;
    public int topWeight;
    public int bottom;
    public int bottomWeight;
    public int left;
    public int leftWeight;
    public int right;
    public int rightWeight;
    public int numConnec;

    // Default constructor, ititializes neghbors to -1 by default and edge
    // weights to 0
    Node () {
        top    = -1;
        right  = -1;
        bottom = -1;
        left   = -1;
    }
} // End Node class


/*
 * The List class contains Nodes, which are linked to one another
 * to create a Linked List. Used as an adjacency list in the
 * UnionFind class
 */
 class List {
    public Node neighbors;

    // Default constructor
    List () {
        neighbors = new Node ();
    }

    /**
     * Generates valid edges for the node, also assigns a randomly generated weight to that edge
     * @param i         The row that the node exists on, used to generate outer-node edges
     * @param j         The index of the node in the maze from 0 to (2^p)^2 - 1
     * @param twoP      Represents the dimensions of the maze, used in calculating valid edges
     * @param choice    Randomly generated number to choose which edge to generate
     * @param weight    Randomly generated number to assign generated edge a weight
     * @return          If the assignment was done correctly, returns true. Else returns false.
     */
    public boolean validEdges (int i, int j, int twoP, int choice, int weight) {
        if (neighbors.numConnec < 4) {
            // Top
            if (choice == 0) {
                neighbors.top = generateTop(i, j, twoP);
                neighbors.topWeight = weight;
                neighbors.numConnec++;
            }

            // Right
            else if (choice == 1) {
                neighbors.right = generateRight(i, j, twoP);
                neighbors.rightWeight = weight;
                neighbors.numConnec++;
            }

            // Bottom
            else if (choice == 2) {
                neighbors.bottom = generateBottom(i, j, twoP);
                neighbors.bottomWeight = weight;
                neighbors.numConnec++;
            }

            // Left
            else if (choice == 3) {
                neighbors.left = generateLeft(i, j, twoP);
                neighbors.leftWeight = weight;
                neighbors.numConnec++;
            }
        }
        else {
            return false;
        }
        return true;
    }

    public int generateTop (int i, int j, int twoP) {
        int neighbor = 0;

        // Set the top neighbor
        if (i == 0) {
            neighbor = j + twoP * (twoP + (-1));
        }
        else {
            neighbor = j + (-twoP);
        }
        return neighbor;
    }

    public int generateRight (int i, int j, int twoP) {
        int neighbor = 0;

        // Set the right neighbor
        if (j == twoP * (i + 1) + (-1)) {
            neighbor = twoP * i;
        }
        else {
            neighbor = j + 1;
        }
        return neighbor;
    }

    public int generateBottom (int i, int j, int twoP) {
        int neighbor = 0;

        // Set the bottom neighbor
        if (i == twoP + (-1)) {
            neighbor = j - twoP * (twoP + (-1));
        }
        else {
            neighbor = j + twoP;
        }
        return neighbor;
    }

    public int generateLeft (int i, int j, int twoP) {
        int neighbor = 0;

        // Set the left neighbor
        if (j == twoP * i) {
            neighbor = twoP * (i + 1) + (-1);
        }
        else {
            neighbor = j + (-1);
        }
        return neighbor;
    }
} // End List class