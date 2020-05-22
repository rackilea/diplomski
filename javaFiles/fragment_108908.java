import java.util.PriorityQueue;

public class Node implements Comparable<Node> {
    Node left;
    Node right;
    Node parent;
    String text;
    int frequency;

    public Node(String textIn, int frequencyIn) {
        text = textIn;
        frequency = frequencyIn;
    }

    public Node(int frequencyIn) {
        text = "";
        frequency = frequencyIn;
    }

    public int compareTo(Node n) {
        if (frequency < n.frequency) {
            return -1;
        }
        else if(frequency > n.frequency) {
            return 1;
        }
        return 0;
    }

    public static void printFromPreOrder(Node n, String dashes) {
        // print with colon if leaf node
        if (n.text != "") {
            System.out.println(dashes + n.frequency + ":" + n.text);
        }
        else {
            System.out.println(dashes + n.frequency);
        }

        // Start recursive on left child then right
        if (n.left != null) {
            printFromPreOrder(n.left, dashes + "-");
        }
        if (n.right != null) {
            printFromPreOrder(n.right, dashes + "-");
        }
    }

    // Returns root node to pass to printFromPreOrder
    public static Node makeHuffmanTree(int frequencies[], String text[]) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for (int i = 0; i < text.length; i++) {
            Node n = new Node(text[i], frequencies[i]);
            queue.add(n);
        }
        Node root = null;
        while (queue.size() > 1)  {
            Node least1 = queue.poll();
            Node least2 = queue.poll();
            Node combined = new Node(least1.frequency + least2.frequency);
            combined.right = least1;
            combined.left = least2;
            least1.parent = combined;
            least2.parent = combined;
            queue.add(combined);
            // Keep track until we actually find the root
            root = combined;
        }
        return root;
    }

    public static void main(String[] args) {
        int frequencies[] = {10, 15, 12, 3, 4, 13, 1};
        String text[] = {"a", "b", "c", "e", "nl", "sp", "t"};
        Node root = Node.makeHuffmanTree(frequencies, text);
        Node.printFromPreOrder(root, "");
    }
}