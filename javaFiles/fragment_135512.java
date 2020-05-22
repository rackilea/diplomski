final List<Element> elements = new ArrayList<Element>();

new NodeTraversor(new NodeVisitor() {
    public void head(Node node, int depth) {
        if (node instanceof Element) {
            Element element = (Element) node;
            if(element.tagName().equalsIgnoreCase("a") && element.hasAttr("href")){
                elements.add(element);
            }
        }
    }

    public void tail(Node node, int depth) {
    }
}).traverse(doc);

return elements;