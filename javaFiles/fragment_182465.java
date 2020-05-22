interface TextFormatter extends Comparable<TextFormatter> {
    TextFormatter clone(String s);
    String format();

    @Override
    default int compareTo(@NotNull TextFormatter other) {
        return format().compareTo(other.format());
    }
}