//Array for testing
    int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(Arrays.deepToString(a));

    //loop through inner array only and reverse items
    for (int i = 0; i < a.length; i++){
        a[i] = reverse(a[i]);
    }
    System.out.println(Arrays.deepToString(a));

    //loop through outer array only and reverse parents.
    //Note that this only needs to goe through half the array that is why we use "a.length / 2".
    for (int i = 0; i < a.length / 2; i++){
        int[] temp = a[i];
        a[i] = a[a.length - i - 1];
        a[a.length - i - 1] = temp;
    }
    System.out.println(Arrays.deepToString(a));