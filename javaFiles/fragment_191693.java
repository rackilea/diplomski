public static void findMatch(char c) {
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == c) {
            correct[i] = c;
            sb.setCharAt(i, c);
        } else if (word.charAt(i) != c) {
            wrong[i] = c;
        }
    }
    System.out.print(sb.toString());
    attempts++;
}

public static void printAstrick() {
    for (int i = 0; i < word.length(); i++) {
        sb.append("*");
    }
    System.out.print(sb.toString());
}