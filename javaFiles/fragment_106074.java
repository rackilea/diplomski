// define actual searcher function as private util
// it's safe to call it as it's only indicates success with boolean
// result, so no exceptions would be thrown
protected boolean appendBlockIfFound(int atIndex, Block tree, boolean replace) {
    if (left == right == null)
        return false;

    // same code as above in appendBlock() method
    ...

    return true;
}

// ... and the real worker, exposed to the class user (developer)
// will throw exception on error
public void appendBlock(int atIndex, Block tree, boolean replace) {
    if (!appendBlockIfFound(atIndex, tree, replace))
        throw Exception(String.format("Child node with index %d not found", atIndex));
}