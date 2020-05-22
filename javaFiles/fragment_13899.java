import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    private static int index;

    public static void main(String[] args) {
        index = 0;

        /* Create the tree recursively. */
        Vertex root = createVertex(4);

        /* Create a hashtable version of the list you want. */
        Hashtable<Integer, ArrayList<Vertex>> map = new Hashtable<Integer, ArrayList<Vertex>>();
        fillList(root, map);

        /* Find the max index. */
        int maxIndex = -1;
        for (int index : map.keySet()) {
            if (maxIndex < index) {
                maxIndex = index;
            }
        }

        /* Copy the items over from the hashtable. */
        ArrayList<ArrayList<Vertex>> list = new ArrayList<ArrayList<Vertex>>(
                maxIndex + 1);
        for (int i = 0; i <= maxIndex; i++) {
            if (map.containsKey(i)) {
                list.add(map.get(i));
            } else {
                list.add(null);
            }
        }

        /* Print it out. */
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Vertex> descedants = list.get(i);
            if (descedants != null) {
                System.out.printf("%d :", i);
                for (Vertex vertex : descedants) {
                    System.out.printf(" %d", vertex.getIndex());
                }
                System.out.println();
            }
        }
    }

    private static void fillList(Vertex vertex,
            Hashtable<Integer, ArrayList<Vertex>> map) {
        /* Create the descendants for the current vertex. */
        ArrayList<Vertex> descendants = new ArrayList<Vertex>();

        /* Add the current vertex to the descendants. */
        map.put(vertex.getIndex(), descendants);
        descendants.add(vertex);

        /*
         * Now recursively call this on the left vertex and then, once that's
         * done, add the left's descendants to this one's descendants.
         */
        Vertex left = vertex.getLeft();
        if (left != null) {
            fillList(left, map);
            for (Vertex leftDescendant : map.get(left.getIndex())) {
                descendants.add(leftDescendant);
            }
        }

        /* Do the same with the right. */
        Vertex right = vertex.getRight();
        if (right != null) {
            fillList(right, map);
            for (Vertex rightDescendant : map.get(right.getIndex())) {
                descendants.add(rightDescendant);
            }
        }
    }

    /* Creates a balanced binary tree recursively with depth i. */
    private static Vertex createVertex(int i) {
        if (i > 0) {
            index++;
            return new Vertex(index, createVertex(i - 1), createVertex(i - 1));
        }

        return null;
    }

}

class Vertex {

    private Vertex right;
    private Vertex left;
    private int index;

    public Vertex(int index, Vertex left, Vertex right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public int getIndex() {
        return this.index;
    }

    public Vertex getLeft() {
        return this.left;
    }

    public Vertex getRight() {
        return this.right;
    }
}