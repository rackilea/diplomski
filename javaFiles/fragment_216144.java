try (Scanner input = new Scanner(System.in)) {
    System.out.print("Please enter the max number:");
    int max = input.nextInt();
    int[] arr1 = new int[max];
    for (int i = 0; i < max; i++) {
        arr1[i] = input.nextInt();
    }

    for (int i = 1; i <= max; i++) {
        System.out.print(arr1[i - 1] + " ");
        if (i % 5 == 0) {
            System.out.println();
        }
    }
    System.out.println();

    double sum = 0.0;
    for (int i = 0; i < max; i++) {
        sum += arr1[i];
    }
    System.out.println("Average: " + (sum / max));
} catch (Exception e) {
    e.printStackTrace();
}