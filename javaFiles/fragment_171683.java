public static void main(String[] args) {
    String unit = "XXX"; // Unit String.
    int width = 21; // You can get this input from user.
    int betweenSpaces = width - 2 * unit.length(), trailingSpaces = 0;

    String[] lines = new String[(width - 2 * unit.length()) / 2 + 1];

    for (int i = 0; i < lines.length; i++) {
        lines[i] = "";
        lines[i] = helper(trailingSpaces, lines[i], unit)
                 + helper(betweenSpaces, lines[i], unit);

        betweenSpaces -= 2; // Decrement space count by 2.
        trailingSpaces += 1; // Increment trailing space count by 1.
    }

    // Printing lines array.
    for (String str : lines)
        System.out.println(str);
    for (int i = lines.length - 2; i >= 0; i--)
        System.out.println(lines[i]);
}

public static String helper(int count, String ref, String unit) {
    for (int j = 0; j < count; j++)
        ref += " ";
    return ref += unit; // 2nd unit string appended.
}