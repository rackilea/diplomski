public List<String> concat(final List<String>... lists) {
    final List<Iterator<String>> it = new LinkedList<>();
    for (List<String> l : lists) {
        it.add(l.iterator());
    }

    final List<String> combined = new ArrayList<>();
    outer:
    while (true) {
        final StringBuilder sb = new StringBuilder();
        for (final Iterator<String> i : it) {
            if (!i.hasNext()) {
                break outer;
            }
            sb.append(i.next());
        }
        combined.add(sb.toString());
    }
    for (final Iterator<String> i : it) {
        if (i.hasNext()) {
            throw new IllegalArgumentException("Lists not the same length.");
        }
    }
    return combined;
}