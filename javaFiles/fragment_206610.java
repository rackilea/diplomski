package com.johanw.stackoverflow.tree;

import com.johanw.stackoverflow.util.Helper;

public class Node<A extends Comparable>{
    private static int AMOUNT_INDENT = 3;

    private int data;
    private Node left, right;

    public Node(int d) {
        data = d;
        left = null;
        right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void indent(StringBuilder builder, int indent) {
        builder.append(Helper.repeat(indent * (AMOUNT_INDENT + 1), " "));
    }

    public void newLine(StringBuilder builder) {
        builder.append(System.lineSeparator());
    }

    public String toString(int indent) {
        StringBuilder builder = new StringBuilder();
        builder.append(data);
        newLine(builder);
        if (left != null) {
            indent(builder, indent);
            builder.append("└" + Helper.repeat(AMOUNT_INDENT, "─") + left.toString(indent + 1));
        }
        if (right != null) {
            indent(builder, indent);
            builder.append("└" + Helper.repeat(AMOUNT_INDENT, "─") + right.toString(indent + 1));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}