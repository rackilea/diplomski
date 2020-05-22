// assumes your code declaring the constants ONE, FRED_TEXT etc is before this line
private static final Map<String, int[]> myMap = Collections.unmodifiableMap(
    new HashMap<String, int[]>() {{
        put(FRED_TEXT, new int[] {ONE, TWO, FOUR});
        put(DAVE_TEXT, new int[] {TWO, THREE});
    }});