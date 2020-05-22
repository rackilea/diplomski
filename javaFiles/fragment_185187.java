private static void simpleValidation(String[] arr) {
    // Undefined Rule: If bad input, print nothing
    if (arr.length != 4)
        return;

    // 1: If a null or empty string present in first two entries of arr, it is a invalid scenario print nothing
    if (isNullOrEmpty(arr[0]) || isNullOrEmpty(arr[1]))
        return;

    // 2: If a null or empty is present in last two entries of arr, and first two entries are not null and not empty print first two entries.
    if (isNullOrEmpty(arr[2]) || isNullOrEmpty(arr[3])) {
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        return;
    }

    // 3: If no entry in arr[] is neither null nor empty check if all entries are numeric. If not print nothing.
    if (! isNumeric(arr[0]) || ! isNumeric(arr[1]) || ! isNumeric(arr[2]) || ! isNumeric(arr[3]))
        return;

    // Undefined Rule: Print all values
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);
    System.out.println(arr[3]);
}
private static boolean isNullOrEmpty(String value) {
    return (value == null || value.isEmpty());
}
private static boolean isNumeric(String value) {
    return value.matches("\\d+");
}