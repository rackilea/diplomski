public static boolean match(String x, String y) {
    return match_helper(x, y, 0);
}

private static boolean match_helper(String x, String y, int counter) {
    if (counter >= x.length()) {
        return true;
    }

    if (x.charAt(counter) == y.charAt(counter)) {
        return match_helper(x, y, counter + 1);
    }

    return false;
}

public static void main(String[] args) {
    System.out.println(match("asdfasdf", "asdfasdf"));
}