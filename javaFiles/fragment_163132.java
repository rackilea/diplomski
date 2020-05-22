private static List<Integer> reverse(final List<Integer> list, final int index) {
    if (index >= list.size()) {
        return new LinkedList<>();
    }

    final List<Integer> res = reverse(list, index + 1);
    res.add(list.get(index));
    return res;
}