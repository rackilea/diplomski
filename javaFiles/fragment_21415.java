class Sample {
    ...

    private final Scanner scanner;

    public Sample(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getDetails() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        sumWithOutRemoval = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            sumWithOutRemoval += array[i];
        }
    }
...