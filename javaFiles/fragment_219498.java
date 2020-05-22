public static String[] removeNulls(String[] array) {
    int countNull = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
            countNull++;
        }
    }

    String[] noNull = new String[array.length - countNull];
    for (int i = 0, j = 0; i < array.length; i++) {
        if (myArray[i] != null)
            noNull[j] = myArray[i];
            j++;
    }
    return noNull;
}