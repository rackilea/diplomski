public static void main(String[] args) {

    int numbersToCompute = 10;
    int lineLength = floydsNumber(numbersToCompute).length();
    for (int i = 0; i <= numbersToCompute; ++i) {
        String floydsNumber = floydsNumber(i);
        for (int spaces = lineLength - floydsNumber.length(); spaces > 0; spaces--) {
            System.out.print(" ");
        }
        System.out.println(floydsNumber.toString());
    }
}

private static String floydsNumber(int i) {
    StringBuilder sb = new StringBuilder();
    for (int j = i; j >= 0; j--) {
        sb.append((int) Math.pow(2, j));
    }
    return sb.toString();
}