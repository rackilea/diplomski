public static int indexOf(char key) {
    if ('0' <= key && key <= '8')
        return key - '0';

    if ('a' <= key && key <= 'f')
        return key - 'a' + 10;

    return -1;
}