public void traverseTree(Tree tree) {

    // print, increment counter, whatever
    System.out.println(tree.toString());

    // traverse children
    int childCount = tree.getChildCount();
    if (childCount == 0) {
        // leaf node, we're done
    } else {
        for (int i = 0; i < childCount; i++) {
            Tree child = tree.getChild(i);
            traverseTree(child);
        }
    }
}