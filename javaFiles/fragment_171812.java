public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[7];
        System.out.print("Enter number of rolls: ");
        int roll = input.nextInt();

        System.out.printf("%-12s%-12s%-12s\n", "#", "Count", "Freq");
        for (int i = 1; i <= roll; i++) {
            array[(int) (6 * Math.random()) + 1]++;
        }
        for (int a = 1; a < array.length; a++) {
            double percentage = ((double) array[a] / roll) * 100;
            System.out.printf("%-12d%-12d%5.2f%%\n", a, array[a], percentage);
        }
        System.out.printf("%-12s%-14s%-12s\n", "Total", roll, "100%");
    }