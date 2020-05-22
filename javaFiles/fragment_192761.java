public static Node toTextElement(String str) {
    Element e = new Element(Tag.valueOf("text"), "");
    e.appendText(str);
    return e;
}

public static void replaceTextNodes(Node root) {
    if (root instanceof TextNode)
        root.replaceWith(toTextElement(((TextNode) root).text()));
    else
        for (Node child : root.childNodes())
            replaceTextNodes(child);
}