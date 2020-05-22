public final char[] take() {
    char[] t = (char[])getQueue().poll();
    if (t == null)
        return new char[4096];
    return t;
}