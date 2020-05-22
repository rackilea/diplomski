interface Node<T extends Node<T>> {

    void addOne(T node);
}

class StringNode implements Node<StringNode> {

    List<StringNode> data = new ArrayList<StringNode>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOne(StringNode node) {
        data.add(node);
    }

}