Node {
    // fields
    parent: Node
    lock: RWLock
    count: AtomicInteger
}

public boolean trylocktree(node: Node, exclusive: boolean) {
    if (exclusive) {
        return trylocktree_ex(node, true);
    } else {
        return trylocktree_sh(node);
    }
}
private boolean switch_count(i: AtomicInteger, diff: int) {
    // adds diff to i if the sign of i is the same as the sign of diff
    while (true) {
        int v = i.get();
        if (diff > 0 ? v < 0 : v > 0)
            return false;
        if (i.compareAndSet(v, v + diff))
            return true;
    }
}
private boolean trylocktree_ex(node: Node, writing: boolean) {
    // check if a node is read-locked
    if (!switch_count(node.count, 1))
        return false;
    // lock using the lock type passed as an arg
    if (!node.lock(writing).trylock()) {
        node.count--;
        return false;
    }
    // read-lock every parent
    if (!trylocktree_ex(node.parent, false)) {
        node.count--
        node.lock(writing).unlock();
        return false;
    }
    return true;
}
private boolean trylocktree_sh(node: Node) {
    // mark as shared-locked subtree
    if (!switch_count(node.count, -1))
        return false;
    // get shared-lock on parents
    if (!readlock_recursively(node)) {
        node.count++;
        return false;
    }
    return true;
}
private boolean readlock_recursively(node: Node) {
    if (!node.lock(false).trylock())
        return false;
    if (!readlock_recursively(node.parent)) {
        node.lock(false).unlock();
        return false;
    }
    return true;
}