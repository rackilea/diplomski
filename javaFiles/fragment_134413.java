public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[][] str, int row, int col) {
    if (leftRem < 0 || rightRem < leftRem) return; // invalid state

    if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(String.copyValueOf(str[i]));
            sb.append(System.lineSeparator());
        }
        list.add(sb.toString());
    } else {
        if (leftRem > 0) { // try a left paren, if there are some available
            str[row][col] = '/';
            addParen(list, leftRem - 1, rightRem, str, row - 1, col + 1);
            str[row][col] = ' ';
        }
        if (rightRem > leftRem) { // try a right paren, if there’s a matching left
            str[row + 1][col] = '\\';
            addParen(list, leftRem, rightRem - 1, str, row + 1, col + 1);
            str[row + 1][col] = ' ';
        }
    }
}

public static ArrayList<String> generateParens(int count) {
    char[][] str = new char[count][count * 2];
    for (int i = 0; i < str.length; i++) {
        Arrays.fill(str[i], ' ');
    }

    ArrayList<String> list = new ArrayList<>();
    addParen(list, count, count, str, count - 1, 0);
    return list;
}