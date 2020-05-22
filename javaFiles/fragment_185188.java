private static void simpleValidation(String[] arr) {
    if (arr.length == 4 && ! isNullOrEmpty(arr[0]) && ! isNullOrEmpty(arr[1]))
        if (isNullOrEmpty(arr[2]) || isNullOrEmpty(arr[3]))
            System.out.printf("%s%n%s%n", arr[0], arr[1]);
        else if (isNumeric(arr[0]) && isNumeric(arr[1]) && isNumeric(arr[2]) && isNumeric(arr[3]))
            System.out.printf("%s%n%s%n%s%n%s%n", arr[0], arr[1], arr[2], arr[3]);
}