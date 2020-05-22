public static void main(String[] args) {
    int array1[] = { 123, 132, 231, 213, 312, 321 };
    int array2[] = {  12,  13,  14,  15,  16,  17,  18,  19, 123, 124, 125, 126, 127 };
    count(array1, array2);
}

private static void count(int[] arr1, int[] arr2) {

    // prepare a mapping of permutations of numbers in arr2 to arr2 indexes 
    int[] permutationGroupOfNumber = new int[1000];
    Arrays.fill(permutationGroupOfNumber, -1);
    for (int i = 0; i < arr2.length; i++) {
        int number = Math.abs(arr2[i]) % 1000; // just to be safe
        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        int digit3 = (number / 100) % 10;
        permutationGroupOfNumber[digit1 + digit2 * 10 + digit3 * 100] = i;
        permutationGroupOfNumber[digit1 + digit3 * 10 + digit2 * 100] = i;
        permutationGroupOfNumber[digit2 + digit1 * 10 + digit3 * 100] = i;
        permutationGroupOfNumber[digit2 + digit3 * 10 + digit1 * 100] = i;
        permutationGroupOfNumber[digit3 + digit1 * 10 + digit2 * 100] = i;
        permutationGroupOfNumber[digit3 + digit2 * 10 + digit1 * 100] = i;
    }

    // count the number of occurrences of permutations in arr1
    int[] occurrencesOfPermutationsInGroup = new int[arr2.length];
    for (int i = 0; i < arr1.length; i++) {
        int g = permutationGroupOfNumber[arr1[i]];
        if (g >= 0)
            occurrencesOfPermutationsInGroup[g]++;
    }

    // output number of occurrences
    for (int i = 0; i < arr2.length; i++) {
        int g = permutationGroupOfNumber[arr2[i]];
        if (occurrencesOfPermutationsInGroup[g] > 0)
            System.out.println(arr2[i] + ": " + occurrencesOfPermutationsInGroup[g] + " time(s)");
    }
}