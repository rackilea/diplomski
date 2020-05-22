public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("numbers.in"));
    int sizeN = scanner.nextInt();
    int[] arrayA = new int[sizeN];
    for (int i = 0; i < sizeN; i++) {
        arrayA[i] = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            if (arrayA[i] == arrayA[j]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}