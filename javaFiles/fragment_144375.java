int[][] table = {
        {78,89,92,95},
        {62,76,88,91},
        {59,68,74,83},
        {48,50,65,72}
    };

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter speed:");
    int speed = scanner.nextInt();
    System.out.println("Enter temperature:");
    int temp = scanner.nextInt();
    int row = (speed / 100) - 1;
    int col = (temp / 10)  - 2;
    float a = table[row][col];
    float b = table[row][col + 1];
    float result = a + (temp % 10) * (b - a) / 10;
    System.out.println(result);