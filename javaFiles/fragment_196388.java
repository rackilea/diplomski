public static List<String> extractComments(final NodeList search) {
    List<String> result = new ArrayList<>();
    for (int i = 0, length = search.getLength(); i < length; i++) {
        Node child = search.item(i);
        if (child.getNodeType() == Node.COMMENT_NODE) {
            result.add(child.getTextContent());
        }
        result.addAll(extractComments(child.getChildNodes()));
    }
    return result;
}