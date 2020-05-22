public BinaryNode getParentOf(BinaryNode target) {

    for(BinaryNode child: children) {
        if (child == target) {
            return this;
        }
        BinaryNode result = child.getParentOf(target);
        if (result != null ) {
            return result;
        }
    }
    return null;
}