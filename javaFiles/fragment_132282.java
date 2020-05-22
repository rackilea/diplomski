public static void main(String[] args) throws Exception {
    System.out.println(calculateRoot(5635)); //prints 1
}

public static int calculateRoot(int n) {
    int sum = sumFigures(n);
    return sum < 10 ? sum : calculateRoot(sum);
}

public static int sumFigures(int n) {
    String s = String.valueOf(n);
    int sum = 0;
    for (char c : s.toCharArray()) {
        sum += c - '0';
    }
    return sum;
}