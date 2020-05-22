public static void main(String[] args) {
    SegmentsAlgorithm algorithm = new SegmentsAlgorithm();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    for (int i = 0; i < n; i++) {
        algorithm.addSegment(scanner.nextInt(), scanner.nextInt());
    }
    algorithm.prepareArrayCache();
    for (int i = 0; i < m; i++) {
        System.out.print(algorithm.searchPoint(scanner.nextInt())+ " ");
    }
    System.out.println();
}