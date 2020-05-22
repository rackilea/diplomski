class LevelIter<Node> implements Iterable<Node> {
    Stack<Node> s = null;
    public LevelIter(Stack<Node> s) {
        this.s = (Stack)s.clone();
    }
    //rest is the same.
}