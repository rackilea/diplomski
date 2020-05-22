node.traverse(new TagNodeVisitor() {
    public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
        if (htmlNode instanceof TagNode) {
            TagNode tag = (TagNode) htmlNode;
            String tagName = tag.getName();
            if ("td".equals(tagName)) {
                System.out.println("All text inside this <td> tag (including children): " + tag.getText());
            }
        }
        // tells visitor to continue traversing the DOM tree
        return true;
    }
});