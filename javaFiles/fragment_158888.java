public static int simplify(String strexp) {
    int length = strexp.length();

    List<Character> usedVariables = new ArrayList<Character>();
    for (int i = 0; i < length; i++) {
        char c = strexp.charAt(i);
        if (Character.isLetter(c) && !usedVariables.contains(c)) {
            usedVariables.add(c);
        }
    }

    return usedVariables.size();
}

public static void main(String[] args) {
    System.out.println(simplify("x + b = d"));
    System.out.println(simplify("x + x = a"));
    System.out.println(simplify("x + x = x / 2"));
}