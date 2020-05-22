public static List<Node> extractComments(final NodeList search) {
    List<Node> result = new ArrayList<>();
    for (int i = 0, length = search.getLength(); i < length; i++) {
        Node child = search.item(i);
        if (child.getNodeType() == Node.COMMENT_NODE) {
            result.add(child);
        }
        result.addAll(extractComments(child.getChildNodes()));
    }
    return result;
}