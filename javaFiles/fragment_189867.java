public static void main(String[] args) {
    String[] arr1 = { "11", "22", "33", "44", "55", "66", "77" };
    String[] arr2 = { "111", "222", "333", "444", "555", "666", "777", "888", "999" };

    String[] arr = mergeArrays(arr1, arr2, 2, 3);

    System.out.println("Ratio 2:3");

    for (String str : arr) {
        System.out.println(str);
    }

    arr = mergeArrays(arr1, arr2, 3, 4);

    System.out.println("Ratio 3:4");

    for (String str : arr) {
        System.out.println(str);
    }
}