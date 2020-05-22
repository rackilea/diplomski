for(int i=1; i<array.length; i++) {
    int checks = 1; // There is always one more check than iterations, the last check being the one which ends the iteration
    for (int j=i; (j>0) && (array[j]<(array[j-1])); j--, checks++) {
        Sort.swap(array, j, j-1);
        swaps++;
    }
    System.out.println(checks);
}