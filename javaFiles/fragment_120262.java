public void plot() {
    if (root == null) {
        throw new BinaryTreeException("Empty Tree");
    }
    int lineCount = 2 * root.getDepth() - 1;
    StringBuilder[] lines = new StringBuilder[lineCount];
    for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
        lines[lineIndex] = new StringBuilder();
    }
    // get the right most node (which contains the largest element value)
    BinaryNode rightMostNode = root;
    while (rightMostNode.right != null) {
        rightMostNode = rightMostNode.right;
    }
    // check how many characters we have to reserve for a single node element
    int maxElementLength = String.valueOf(rightMostNode.element).length();
    plot(root, 0, 0, maxElementLength, lines);
    for (StringBuilder singleLine : lines) {
        System.out.println(singleLine.toString());
    }
}

private void plot(BinaryNode subTreeRoot, int offset, int lineIndex, int elementLength, StringBuilder[] lines) {
    int actualOffset;
    if (subTreeRoot.left == null) {
        actualOffset = offset;
    } else {
        actualOffset = offset + (int) Math.pow(2, subTreeRoot.left.getDepth() - 1) * elementLength;
    }
    StringBuilder currentLine = lines[lineIndex];
    String elementValue = String.valueOf(subTreeRoot.element);
    for (int lineFillIndex = currentLine.length() + elementValue.length() / 2; lineFillIndex < actualOffset; lineFillIndex++) {
        currentLine.append(' ');
    }
    currentLine.append(elementValue);
    if (subTreeRoot.left != null) {
        // draw connection to left sub tree
        int connectPosition = (actualOffset - offset) * 3 / 4 + offset;
        StringBuilder connectLine = lines[lineIndex + 1];
        for (int lineFillIndex = connectLine.length(); lineFillIndex < connectPosition; lineFillIndex++) {
            connectLine.append(' ');
        }
        connectLine.append('/');
        // insert the left part of the next value line
        plot(subTreeRoot.left, offset, lineIndex + 2, elementLength, lines);
    }
    if (subTreeRoot.right != null) {
        // draw connection to right sub tree
        int connectPosition = actualOffset + elementLength - elementValue.length() / 2;
        if (subTreeRoot.right.left != null) {
            connectPosition += (int) Math.pow(2, subTreeRoot.right.left.getDepth() - 1) * elementLength / 2;
        }
        StringBuilder connectLine = lines[lineIndex + 1];
        for (int lineFillIndex = connectLine.length(); lineFillIndex < connectPosition; lineFillIndex++) {
            connectLine.append(' ');
        }
        connectLine.append('\\');
        // insert the right part of the next value line
        plot(subTreeRoot.right, actualOffset + elementLength, lineIndex + 2, elementLength, lines);
    }
}