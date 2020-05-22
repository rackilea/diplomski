public static int rec(char ch, FileInputStream fis) throws IOException {

    char current = 0;
    if (fis.available() == 0) {
        return 0;
    }
    int read = fis.read();
    if (read != -1) {
        current = (char) read;
    }

    if (current == ch) {

        return 1 + rec(ch, fis);
    }

    else
        return rec(ch, fis);

}