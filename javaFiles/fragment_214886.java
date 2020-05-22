int[] array = {2, -5, 4, 12, 54, -2, -50, 150};
Arrays.sort(array);
for (int i = 0, iFirstPositive = 0; i < array.length; i++) {
    if (array[i] < 0)
        iFirstPositive = i + 1; // Assume index of first positive value is next
    if (i == iFirstPositive) {
        if (i != 0)
            System.out.println(); // End line of negative values
        System.out.print("Greater than 0: "); // Start line of positive values
    } else if (i == 0) {
        System.out.print("Less than 0: "); // Start line of negative values
    } else {
        System.out.print(", ");
    }
    System.out.print(array[i]);
}
if (array.length != 0) {
    System.out.println(); // End line if anything printed
}