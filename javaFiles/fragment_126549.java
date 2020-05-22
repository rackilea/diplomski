public TemporalAccessor parse(final CharSequence text) {
    ParsePosition pos = new ParsePosition(0);
    TemporalAccessor temporalAccessor = DateTimeFormatter.ISO_ZONED_DATE_TIME.parseUnresolved(text, pos);
    if (temporalAccessor == null || pos.getErrorIndex() >= 0 || pos.getIndex() < text.length()) {
        return null;
    }
    return temporalAccessor;
}