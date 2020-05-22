private void CountMatching(Object[] array, Object[] array1) {
    int count = 0;
    for (Object arrayEntry : array) {
        for (Object array1Entry : array1) {
            if (arrayEntry == array1Entry) {
                count++;
            }
        }
    }
    System.out.println(count);
}