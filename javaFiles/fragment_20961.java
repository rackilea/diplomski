private void CountMatching(Object[] array, Object[] array1) {
    int count = 0;
    for (int a = 0; a < array.length; a++) {
        for (int b = 0; b < array1.length; b++) {
            if (array[a] == array1[b]) {
                count++;
            }
        }
    }
    System.out.println(count);
}