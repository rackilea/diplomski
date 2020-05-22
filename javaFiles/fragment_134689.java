public static void combine(List<Character> colors, List<Character> combination) {
    if (combination.size() == colors.size()) {
        System.out.println(combination);
    } else {
        for (char color : colors) {
            combination.add(color);
            combine(colors, combination);
            combination.remove(combination.size() - 1);
        }
    }
}

public static void main(String[] args) {
    List<Character> colors = new ArrayList<>();
    colors.add('W');
    colors.add('B');
    colors.add('G');

    combine(colors, new LinkedList<Character>());
}