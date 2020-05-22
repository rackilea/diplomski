private static void printOut(int pass, int[] list) {
    System.out.print("PASS " + pass + ": ");
    for (int i = 0; i < list.length - 1; i++) {
        System.out.print(list[i] + ", ");
    }
    // Shows very last integer with a period
    System.out.print(list[list.length - 1] + ".");
    System.out.println();
}