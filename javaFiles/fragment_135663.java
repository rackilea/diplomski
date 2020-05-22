public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("numbers.in"));
    int sizeN = scanner.nextInt();
    int[] arrayA = new int[sizeN];
    boolean found = false;
    for (int i = 0; !found && i < sizeN; i++) {
        arrayA[i] = scanner.nextInt();
        for (int j = 0; !found && j < i; j++) {
            if (arrayA[i] == arrayA[j]) {
                found = true;
            }
        }
    }
    if (found) {
        System.out.println("Yes");
    } else {
        System.out.println("No");
    }
}