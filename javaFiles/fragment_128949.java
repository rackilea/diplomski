Predicate<String> filter_1 = str -> "value".equals(str);
Predicate<String> filter_2 = "value"::equals;
Predicate<String> filter_3 = new Predicate<String>() {
    @Override
    public boolean test(String s) {
        return "value".equals(s);
    }

};

Predicate<String> minLengthFilter = str -> str != null && str.length() > 5;
Predicate<String> maxLengthFilter = str -> str != null && str.length() < 8;
Predicate<String> combined = minLengthFilter.and(maxLengthFilter);