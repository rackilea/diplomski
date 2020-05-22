class StringFinder {
    private final String phrase;
    private final Map<String, Boolean> cache = new HashMap<String, Boolean>();

    public StringFinder(String phrase) { this.phrase = phrase; }

    public StringFinder containsAll(String... strings) {
        for (String string : strings) {
            if (contains(string) == false) return new FailedStringFinder(phrase);
        }
        return this;
    }

    public StringFinder andOneOf(String... strings) {
        for (String string: strings) {
            if (contains(string)) return this;
        }
        return FailedStringFinder(phrase);
    }

    public StringFinder andNot(String... strings) {
        for (String string : strings) {
            if (contains(string)) return new FailedStringFinder(phrase);
        }
        return this;
    }

    public boolean matches() { return true; }

    private boolean contains(String s) {
        Boolean cached = cache.get(s);
        if (cached == null) {
            cached = phrase.contains(s);
            cached.put(s, cached);
        }
        return cached;
    }


}

class FailedStringFinder extends StringFinder {
    public boolean matches() { return false; }

    // The below are actually optional, but save on performance:
    public StringFinder containsAll(String... strings) { return this; }
    public StringFinder andOneOf(String... strings) { return this; }
    public StringFinder andNot(String... strings) { return this; }
}