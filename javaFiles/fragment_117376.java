static String join(Iterable<String> strings, String separator, String lastSeparator)
{
    checkNotNull(strings);
    int size = Iterables.size(strings);
    switch (size) {
        case 0:
            return "";
        case 1:
            return strings.iterator().next();
        default:
            return Joiner.on(separator).join(Iterables.limit(strings, size - 1))
                    + lastSeparator + Iterables.getLast(strings);
    }
}