import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;


public class BidirectionalSearch {

    /*
     * Returns true if a path exists between Node a and b, false otherwise.
     * */
    public static boolean pathExists(Node a, Node b) {
        // LinkedList implements the Queue interface, FIFO queue operations (e.g., add and poll).

        // Queue to hold the paths from Node a.
        Queue<Node> queueA = new LinkedList<>();

        // Queue to hold the paths from Node a.
        Queue<Node> queueB = new LinkedList<>();

        // A set of visited nodes starting from Node a.
        Set<Node> visitedA = new HashSet<>();

        // A set of visited nodes starting from Node b.
        Set<Node> visitedB = new HashSet<>();

        visitedA.add(a);
        visitedB.add(b);

        queueA.add(a);
        queueB.add(b);

        // Both queues need to be empty to exit the while loop.
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            if (pathExistsHelper(queueA, visitedA, visitedB)) {
                return true;
            }
            if (pathExistsHelper(queueB, visitedB, visitedA)) {
                return true;
            }
        }

        return false;
    }

    private static boolean pathExistsHelper(Queue<Node> queue,
                                            Set<Node> visitedFromThisSide,
                                            Set<Node> visitedFromThatSide) {
        if (!queue.isEmpty()) {
            Node next = queue.remove();

            Set<Node> adjacentNodes = next.getAdjacentNodes();

            for (Node adjacent : adjacentNodes) {

                // If the visited nodes, starting from the other direction,
                // contain the "adjacent" node of "next", then we can terminate the search
                if (visitedFromThatSide.contains(adjacent)) {
                    return true;
                } else if (visitedFromThisSide.add(adjacent)) {
                    queue.add(adjacent);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test here the implementation above.
    }
}