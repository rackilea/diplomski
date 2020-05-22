public static void main(String[] args) {
    Set<String> s = Arrays.stream(new String[] {
        "Stack Overflow",
        "Flowover Stack",
        "Overflow Stack",
        "Stackover Flow"
    }).collect(Collectors.toSet());
    System.out.println(findMatches(s, "Over"));
}

public static Set<String> findMatches (Set<String> names, String input) {
    int inputLength = input.length();
    return names.stream().parallel().filter(name -> {
        int offset = 0;
        while (offset >= 0 && offset + inputLength < name.length()) {
            if (name.startsWith(input, offset)) {
                return true;
            }
            offset = name.indexOf(" ", offset);
            if (offset != -1) {
                offset++;
            }
        }
        return false;
    }).collect(Collectors.toSet());
}