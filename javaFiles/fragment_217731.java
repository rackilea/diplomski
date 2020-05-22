// pseudocode
recursiveCheck(node) {
    if (charCount.containsKey(node.character) && charCount.get(node.character) > node.count) {
        if (node.hasChildren()) {
            for (childnode in node) {
                recursiveCheck(childnode);
            }
        }
        else {
            // node is leaf, node.number is contained
        }
    }
}