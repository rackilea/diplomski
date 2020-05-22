public Key ceiling_i(Key key)
{
    Node t = root;
    Node t largestVisited = null;
    while(t != null) {
        int cmp = key.compareTo(t.key);
        if(cmp == 0) return t.key;
        else if(cmp < 0) { largestVisited = Min(t, largestVisited); t = t.left; }
        else if(cmp > 0) { t = t.right; largestVisited = Min(t, largestVisited); }

    }
    return largestVisited;
}

Node Min(Node a, Node b) { return the node with the smaller key; }