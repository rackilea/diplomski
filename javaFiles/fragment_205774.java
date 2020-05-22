List<String> foo = /* init */;

Comparator<String> ignoreLeadingThe = new Comparator<String>() {
    @Override public int compare(String a, String b) {
        // TODO check for nulls?

        // (?i) makes the match case-insensitive
        a = a.replaceAll("(?i)^the\\s+", "");
        b = b.replaceAll("(?i)^the\\s+", "");

        // TODO use compareToIgnoreCase() instead?
        return a.compareTo(b);
    }
};

Collections.sort(foo, ignoreLeadingThe);