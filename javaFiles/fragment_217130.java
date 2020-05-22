interface Node {
    int size();
    Node next();
}

class EmptyNode implements Node {
    @Overide
    public int size() {
        return 0;
    }
    ...
}

class NotEmptyNode implements Node {
    @Overide
    public int size() {
        return 1 + next().size();
    }
    ...
}

...

class List {
    Node n;

    public int getSize() {
        return n.size();
    }
}