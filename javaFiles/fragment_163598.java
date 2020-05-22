public DLL dll(Node x) {
    return dll(null, x, null);
}

public DLL dll(DLL before, Node x, DDL after) {
    if (x == null) {
        return;
    }
    if (x.left != null) {
        before = dll(before, x.left, null);
    }
    if (x.right != null) {
        after = dll(null, x.left, after);
    }
    DLL result = new DLL();
    result.insert(x.value);
    result.insertBefore(before); // null being a no-op.
    result.insertAfter(after); // null being a no-op.
    return result;
}