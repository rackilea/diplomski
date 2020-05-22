public static int indexOf(char[] array, char key) {
    for (int i = 0; i < array.length; i++)
        if (array[i] == key)
            return i;

    return -1;
}