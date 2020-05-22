if (indexOf > -1) {
    String newArray[] = new String[arrays.length - 1];
    for (int index = 0; index < indexOf; index++) {
        newArray[index] = arrays[index];
    }
    for (int index = indexOf + 1; index < arrays.length; index++) {
        newArray[index - 1] = arrays[index];
    }
    arrays = newArray;
}