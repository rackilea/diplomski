public static void main (String[] args) {
    System.out.println(conditionTesting(0, -1));  // true
    System.out.println(conditionTesting(-1, -1)); // false
    System.out.println(conditionTesting(5, -1));  // false
    System.out.println(conditionTesting(-1, 10)); // false
    System.out.println(conditionTesting(6, 9));   // true
}

public static boolean conditionTesting(int x, int y) {
    return !(x == -1 && y == -1 || x == 5 || y == 10);
}