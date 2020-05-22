private static String toText(Element element) {
    final StringBuilder accum = new StringBuilder();
    new NodeTraversor(new NodeVisitor() {
        public void head(Node node, int depth) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                accum.append(textNode.getWholeText());
            } else if (node instanceof Element) {
                // Do nothing ...
            }
        }

        public void tail(Node node, int depth) {
        }
    }).traverse(element);

    return accum.toString().trim();
}