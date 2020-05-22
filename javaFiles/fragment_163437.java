private static Iterable<Node> iterableNodes(
    Supplier<int> lengthGetter,
    Function<int, Node> itemGetter
) {
     return () -> new Iterator<Node>() {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < lengthGetter.get();
        }

        @Override
        public Node next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return itemGetter.apply(index++);
        }
    };
}

private static Iterable<Node> iterableNamedNodeMap(NamedNodeMap namedNodeMap) {
    return iterableNodes(namedNodeMap::getLength, namedNodeMap::item);
}

private static Iterable<Node> iterableNodeList(NodeList nodeList) {
    return iterableNodes(nodeList::getLength, nodeList::item);
}