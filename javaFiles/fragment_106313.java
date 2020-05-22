public static int countHi(String str) {
    int pos = -1, count = -1;

    do {
        count++;
        pos = str.indexOf("hi", pos + 1);
    } while (pos != -1);

    return count;
}