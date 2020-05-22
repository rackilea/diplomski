int[] array = {2, -5, 4, 12, 54, -2, -50, 150};
Arrays.sort(array);
System.out.print("Less than 0:");
for (int i = 0; i < array.length; i++) {
    if (array[i] < 0) {
        System.out.print(" " + array[i]);
    }
}
System.out.println();
System.out.print("Greater than 0:");
for (int i = 0; i < array.length; i++) {
    if (array[i] > 0) {
        System.out.print(" " + array[i]);
    }
}
System.out.println();