int[] arr = { 3, 5, 6, 7, 3, 5, 3, 8 };
int noOfItemsToBeDeleted=4;
for (int i = 0; i < noOfItemsToBeDeleted; i++) {
    if (arr.length > 0) {
        arr = ArrayUtils.remove(arr, arr.length-1);
    }
}
for (int i : arr) {
    System.out.println(i);
}