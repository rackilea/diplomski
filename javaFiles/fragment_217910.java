public String concat(String s) {

    int i = s.length();
    if (i == 0) {
        return this;
    } else {
        char ac[] = new char[count + i];
        getChars(0, count, ac, 0);
        s.getChars(0, i, ac, count);
        return new String(0, count + i, ac);
    }
}