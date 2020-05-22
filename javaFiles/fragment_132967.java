// Main class TreeFromScratch:

import java.awt.BorderLayout;
import javax.swing.*;

public class TreeFromScratch {
    public static void main(final String[] arguments) {
        SwingUtilities.invokeLater(() -> new TreeFromScratch().createAndShowGui());
    }

    private void createAndShowGui() {
        final JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 1200, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel(new BorderLayout());
        final Node tree = createTree();
        panel.add(new CustomTree(tree), BorderLayout.CENTER);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private Node createTree() {
        final Node tree = new Node('a');
        tree.leftChild = new Node('b');

        tree.leftChild.leftChild = new Node('c');
        tree.leftChild.leftChild.leftChild = new Node('d');
        tree.leftChild.leftChild.leftChild.leftChild = new Node('e');
        tree.leftChild.leftChild.leftChild.leftChild.leftChild = new Node('f');

        tree.leftChild.rightChild = new Node('g');
        tree.leftChild.rightChild.rightChild = new Node('h');
        tree.leftChild.rightChild.rightChild.rightChild = new Node('i');
        tree.leftChild.rightChild.rightChild.rightChild.rightChild = new Node('j');

        tree.rightChild = new Node('k');
        tree.rightChild.leftChild = new Node('l');
        tree.rightChild.leftChild.leftChild = new Node('m');
        tree.rightChild.leftChild.leftChild.leftChild = new Node('n');
        tree.rightChild.leftChild.leftChild.leftChild.leftChild = new Node('o');

        return tree;
    }
}


// Class CustomTree:

import java.awt.Graphics;
import javax.swing.JPanel;

public class CustomTree extends JPanel {
    private Node tree;
    private int radius = 40;

    public CustomTree(Node tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        displayTree(g, tree, 660, 100, 1);
    }

    //displayTree() with crossing issue
    //**************************************************************************
    public void displayTree(Graphics g, Node localTree, int x, int y, int level) {
        // Display the root
        int verticalGap = 50;
        //int horizontalGap = 250 / level;
        int horizontalGap = (int) (660 / Math.pow(2, level));

        g.drawOval(x, y, radius, radius);
        g.drawString(localTree.getKey() + "", x + (radius / 4), y + 20);

        if (localTree.getLeft() != null) {
            // Draw a line to the left node
            lineToLeftChild(g, x - horizontalGap, y + verticalGap, x, y);
            // Draw the left subtree recursively
            displayTree(g, localTree.leftChild, x - horizontalGap, y + verticalGap,
                        level + 1);
        }

        if (localTree.rightChild != null) {
            // Draw a line to the right node
            lineToRightChild(g, x + horizontalGap, y + verticalGap, x, y);
            // Draw the right subtree recursively
            displayTree(g, localTree.rightChild, x + horizontalGap, y + verticalGap,
                        level + 1);
        }
    }//end displayTree()
    //**************************************************************************

    //Line to child
    //**************************************************************************
    private void lineToLeftChild(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1 + (radius / 2), y1, x2, y2 + (radius / 2));
    }//end LinetoLeft
    //**************************************************************************

    //Line to child
    //**************************************************************************
    private void lineToRightChild(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1 + (radius / 2), y1, (x2 + radius), y2 + (radius / 2));
    }//end line to Right()
    //**************************************************************************
}


// Class Node:

public class Node {
    private char key;
    protected Node leftChild;
    protected Node rightChild;

    public Node(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }

    public Node getLeft() {
        return leftChild;
    }
}