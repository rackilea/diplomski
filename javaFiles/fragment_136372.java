int getIndexOfFirstFound(String text, String[] words) {
    return Arrays.stream(words)
            .mapToInt(text::indexOf)
            .filter(i -> i >= 0)
            .findFirst()
            .orElse(-1);
}