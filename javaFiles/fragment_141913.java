private static boolean isLetterOrDigit(char c) {
    return (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9');
}

public static void main(String[] args) {
    String inputString = "blabla!!123";

    Map<Character, Integer> map = new HashMap<>();

    for (char c : inputString.toCharArray()) {
        if (!isLetterOrDigit(c)) {
            c = '*';
        }
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (Character ch : map.keySet()) {
        System.out.println(ch + "(" + map.get(ch) + ")");
    }
}