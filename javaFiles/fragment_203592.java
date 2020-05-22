public String truncate(final String content, final int lastIndex) {
    String result = content.substring(0, lastIndex);
    if (content.charAt(lastIndex) != ' ') {
        result = result.substring(0, result.lastIndexOf(" "));
    }
    return result;
}