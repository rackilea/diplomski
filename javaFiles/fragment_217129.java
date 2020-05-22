interface Node {
    boolean isEmpty();
}

class EmptyNode implments Node {
    @Override
    public boolean isEmpty() { return true; }
}

class NotEmptyNode implements Node {
    @Override
    public boolean isEmpty() { return false; }
}

...

public int getSize(Node start) {
    if (start.isEmpty()) {
        ...
    }
    else {
        ...
    }
}