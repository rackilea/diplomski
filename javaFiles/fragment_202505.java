public static String[] ExtendArray(String[] stringArray) {

    String[] secondArray = new String[stringArray.length * 2];
    // Copy first array into second array
    for (int i = 0; i < stringArray.length; i++) {
        secondArray[i] = stringArray[i];
    }

    return secondArray;
}