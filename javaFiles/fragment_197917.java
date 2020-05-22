interface TreeFolder {
    Object onEmpty();
    Object onLeaf (int n);
    Object onNode (Tree l, Tree r);
}

interface Tree {
    Object fold (TreeFolder f);
}

class Empty implements Tree {
    Object fold (TreeFolder f) {
        return f.onEmpty();
    }
}

class Leaf implements Tree {
    private int n;
    Object fold (TreeFolder f) {
        return f.onLeaf (n);
    }
}

class Node implements Tree {
    private Tree l, r;
    Object fold (TreeFolder f) {
        return f.onNode (l, r);
    }
}

// meanwhile, in a class in another package far far away...
Object depth (Tree tree) {
    return tree.fold (new TreeFolder() {
        Object onEmpty() { return new Integer(0); }
        Object onLeaf (int n) { return new Integer(n); }
        Object onNode (Tree l, Tree r) {
            Integer ll = (Integer) l.fold (this);
            Integer rr = (Integer) r.fold (this);
            return new Integer (ll.intValue() + rr.intValue());
        }
    });
}