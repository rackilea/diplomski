interface TextFormatter {
    public TextFormatter clone(String s);
    public String format();
}

class SnakeCaseFormatter implements TextFormatter, Comparable<TextFormatter> {

    ...

    @Override
    public int compareTo(TextFormatter other) {
        return format().compareTo(other.format());
    }
}