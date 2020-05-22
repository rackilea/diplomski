public static String removeDuplicate(String s) {
    StringBuilder sb = new StringBuilder();
    Set<Character> metChars = new HashSet<>();
    for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(!metChars.contains(c)) {
            sb.append(c);
            metChars.add(c);
        }
    }
    return sb.toString();
}