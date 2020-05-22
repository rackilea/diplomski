private static void reverse(final List<Integer> list, final int index) {
    if (index >= list.size()) {
        return;
    }

    final int currentVal = list.get(index);
    reverse(list, index + 1);
    list.set(list.size() - 1 - index, currentVal);
}