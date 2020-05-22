for (;;) {
    int len = in.read(ch);
    if (len == -1) {
        break;
    }
    out.write(ch, 0, len);
}