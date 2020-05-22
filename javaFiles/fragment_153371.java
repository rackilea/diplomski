public static void main(String[] args) {
    int n = 5, padding = findPadding((int) Math.pow(2, n - 1));
    for (int i = 0; i < n; i++) {
        printBinary((int) Math.pow(2, i), padding);
    }
}

static int findPadding(int value) {
    int bitCount = Integer.toString(value, 2).length(), padding;
    for (int i = 2; ; i++) {
        padding = (int) Math.pow(2, i);
        if (padding >= bitCount) {
            return padding;
        }
    }
}

static void printBinary(int value, int padding) {
    String binaryString = String.format("%0" + padding + "d", Integer.parseInt(Integer.toString(value, 2)));
    int i = 0;
    for (char ch : binaryString.toCharArray()) {
        System.out.print(ch);
        if (++i == 4) {
            System.out.print(" ");
            i = 0;
        }
    }
    System.out.println();
}