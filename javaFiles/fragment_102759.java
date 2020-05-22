private Scanner(Readable source, Pattern pattern) {
    if (source == null)
        throw new NullPointerException("source");
    if (pattern == null)
        throw new NullPointerException("pattern");
    this.source = source;
    delimPattern = pattern;
    buf = CharBuffer.allocate(BUFFER_SIZE);
    buf.limit(0);
    matcher = delimPattern.matcher(buf);
    matcher.useTransparentBounds(true);
    matcher.useAnchoringBounds(false);
    useLocale(Locale.getDefault());
}