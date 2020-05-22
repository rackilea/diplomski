class Strings {
    public static boolean availableOnlyOnce(String source, char c) {
        if (source == null || source.isEmpty()) {
            return false;
        }

        int indexOf = source.indexOf(c);
        return (indexOf == source.lastIndexOf(c)) && indexOf != -1;
    }
}