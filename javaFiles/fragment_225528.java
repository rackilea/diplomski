public static void main(String[] args) {
    int x = 7;
    int result = -1;
    while (true) {
        if ((x % 2 == 1) && (x % 3 == 2) && (x % 4 == 3) && (x % 5 == 4)
                && (x % 6 == 5)) {
            result = x;
            break;
        }
        x += 7; // This because you know its multiple of 7
    }
    System.out.println("Result is: " + result);
}