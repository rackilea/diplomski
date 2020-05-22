private static void myfunction(Node element) {
    for (Node n : element.childNodes()) {
        if (n instanceof TextNode && !((TextNode) n).isBlank()) {
            System.out.println(((TextNode) n).text());
        } else {
            myfunction(n);
        }
    }
}