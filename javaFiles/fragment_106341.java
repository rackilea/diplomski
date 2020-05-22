package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {

    private final static int BLACK = 1;
    private final static int RED = 2;
    private Tree left = null;
    private Tree right = null;
    private int color = BLACK;
    private String value = "";

    Tree(final Tree left, final Tree right, final int color, final String value) {
        this.left = left;
        this.right = right;
        this.color = color;
        this.value = value;
    }

    Tree getLeft() {
        return left;
    }

    Tree getRight() {
        return right;
    }

    int getColor() {
        return color;
    }

    String getValue() {
        return value;
    }

    public static void main(String[] args) {

        Tree leaf1 = new Tree(null, null, RED, "20");
        Tree leaf2 = new Tree(null, null, BLACK, "30");
        Tree leaf3 = new Tree(null, null, RED, "2");
        Tree leaf4 = new Tree(null, null, RED, "100");
        Tree leaf5 = new Tree(null, null, BLACK, "5");

        Tree middle1 = new Tree(leaf1, leaf2, RED, "40");
        Tree middle2 = new Tree(middle1, leaf3, BLACK, "200");
        Tree middle3 = new Tree(leaf4, leaf5, RED, "3");

        Tree root = new Tree(middle2, middle3, RED, "50");

        printTree(root);

    }

    static void printTree(final Tree t) {

        final Map<Tree, Integer> widths = new HashMap<Tree, Integer>();
        final Map<Tree, Integer> offsets = new HashMap<Tree, Integer>();

        setWidths(widths, t);

        setOffsets(offsets, widths, t, widths.get(t)/2);

        final List<Tree> root = new ArrayList<Tree>();
        root.add(t);
        printTree(offsets, root);

    }

    static int setWidths(final Map<Tree, Integer> widths, final Tree t) {

        if(widths.containsKey(t))
            return widths.get(t);

        int width = (t.getColor() == BLACK) ? t.getValue().length()
                    : t.getValue().length() + 2;

        final Tree left = t.getLeft();
        final Tree right = t.getRight();

        if(left != null)
            width += setWidths(widths, left);
        if(right != null)
            width += setWidths(widths, right);

        widths.put(t, width);

        return width;

    }

    static void setOffsets(final Map<Tree, Integer> offsets, final Map<Tree, Integer> widths,
            final Tree t, final int offset) {

        offsets.put(t, offset);

        System.out.println("Parent offset for node " + t.getValue() + ", offset " + offset);

        final Tree left = t.getLeft();
        final Tree right = t.getRight();

        if(left != null)
            setOffsets(offsets, widths, left, offset - widths.get(left)/2);
        if(right != null)
            setOffsets(offsets, widths, right, offset + widths.get(right)/2);

    }

    static void printTree(final Map<Tree, Integer> offsets, final List<Tree> trees) {

        if(trees.isEmpty())
            return;

        final List<Tree> children = new ArrayList<Tree>();
        int linePos = 0;

        for(int i = 0; i < trees.size(); ++i) {

            final Tree t = trees.get(i);

            int offset = offsets.get(t);
            final char[] lead = new char[Math.max(offset - linePos, 0)];
            Arrays.fill(lead, ' ');

            System.out.print(new String(lead));
            linePos += Math.max(offset, 0);

            if(t.getColor() == RED) {
                System.out.print(t.getValue());
                linePos += t.getValue().length();
            } else {
                System.out.print("<" + t.getValue() + ">");
                linePos += t.getValue().length() + 2;
            }

            if(t.getLeft() != null)
                children.add(t.getLeft());
            if(t.getRight() != null)
                children.add(t.getRight());

        }

        System.out.println("");

        printTree(offsets, children);

    }

}