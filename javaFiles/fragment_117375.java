static String join(List<String> strings, String separator, String lastSeparator)
{
    checkNotNull(strings);
    switch (strings.size()) {
        case 0:
            return "";
        case 1:
            return strings.get(0);
        default:
            return Joiner.on(separator).join(strings.subList(0, strings.size() - 1))
                    + lastSeparator + strings.get(strings.size() - 1);
    }
}