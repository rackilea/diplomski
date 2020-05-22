for (int key : keysArr) {
    int result = linearSearch(array1, key);
    if (result != -1)
        System.out.print("The element " +key+" is present in the array, at index " + result + " ");
    else
        System.out.print("The element " +key+" is not present in the array ");
}