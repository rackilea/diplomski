private static final Map<Character, Integer> CONST_CHAR_INT_MAP =
        Collections.unmodifiableMap(new HashMap<Character, Integer>() {{
            put('A', 1);
            put('B', 2);
            put('C', 3);
            // ...
        }});

public int charAt(char c) {
    return CONST_CHAR_INT_MAP.get(c);
}