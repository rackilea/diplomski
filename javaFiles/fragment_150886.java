public static void main(String[] args) {
    Map<Character, Character> replacements = new HashMap<>();
    replacements.put('a', 'c');
    replacements.put('b', 'p');
    replacements.put('c', 'q');

    String input = "abcd";
    StringBuilder output = new StringBuilder();
    for (Character c : input.toCharArray()) {
        output.append(replacements.getOrDefault(c, c));
    }
    System.out.println(output.toString());
}