private static Map<Character, Character> REPLACEMENTS = new HashMap<>();
static {
    REPLACEMENTS.put('α','a');
    REPLACEMENTS.put('β','b');
}

public static String replaceChars(String input) {
    StringBuilder sb = new StringBuilder(input.length());
    for(int i = 0;i<input.length();++i) {
        char currentChar = input.charAt(i);
        sb.append(REPLACEMENTS.getOrDefault(currentChar, currentChar));
    }
    return sb.toString();
}