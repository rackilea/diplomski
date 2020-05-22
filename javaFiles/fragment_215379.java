public static Elements collect (Evaluator eval, Element root) {
    Elements elements = new Elements();
    new NodeTraversor(new Accumulator(root, elements, eval)).traverse(root);
    return elements;
}

private static class Accumulator implements NodeVisitor {
    /* uninteresting parts removed */
    public void head(Node node, int depth) {
        if (node instanceof Element) {
            Element el = (Element) node;
            if (eval.matches(root, el))
                elements.add(el);
        }
    }
}