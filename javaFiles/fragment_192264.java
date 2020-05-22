private static List<Integer> extractValues(Node n) {
    List<Integer> result = new ArrayList<>();
    if (n.getLeft() != null) {
        result.addAll(extractValues(n.getLeft()));
    }

    if (n.getRight() != null) {
        result.addAll(extractValues(n.getRight()));
    }

    result.add(n.getValue());

    return result;
}