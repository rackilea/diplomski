private void processInContent(Node ele) {
    String text = "";        

    ArrayList<Node> toReplace = new ArrayList<Node>();
    for (Node child : ele.childNodes()) {            
        Node parentNode = child.parentNode();
        if (child instanceof TextNode && !("a").equalsIgnoreCase(parentNode.nodeName())) {
            toReplace.add(child);
        }
    }
    for (Node child : toReplace){
        TextNode childText = (TextNode) child;
        text = childText.text();
        Matcher m = pattern .matcher(text);
        while (m.find()) {
            // more code .........
            Element anchorEle = ele.ownerDocument().createElement("a");
            // more code .........
        }
    }
}