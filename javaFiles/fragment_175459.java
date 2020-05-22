for (i = 0; i < 10; i++) {
    System.out.println("Input a number for " + (i + 1) + ": ");
    int input = scan.nextInt();
    if (input == -9000) {
        break;
    }
    array1[i] = input;
}
int[] array2 = Arrays.copyOfRange(array1, 0, i);
System.out.println("Before sorting: " + Arrays.toString(array2));
Arrays.sort(array2); // <-- How I would sort.
System.out.println("After sorting: " + Arrays.toString(array2));