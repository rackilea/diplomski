class ParseResult {
    private final List<KeyValuePair> sanitized = new ArrayList<KeyValuePair>();
    private final List<KeyValuePair> badKey = new ArrayList<KeyValuePair>();
    private final List<KeyValuePair> badValue = new ArrayList<KeyValuePair>();
    public ParseResult(List<KeyValuePair> s, List<KeyValuePair> bk, List<KeyValuePair> bv) {
        sanitized = s;
        badKey = bk;
        badValue = bv;
    }
    public List<KeyValuePair> getSanitized() { return sanitized; }
    public List<KeyValuePair> getBadKey() { return badKey; }
    public List<KeyValuePair> getBadValue() { return badValue; }
}