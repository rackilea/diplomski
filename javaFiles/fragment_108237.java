public String concat(String[] args){
    int length = 0;
    for (String s : args) {
        length += s.length();
    }
    char[] result = new char[length];

    int i = 0;

    for (String s : args) {
        s.getChars(0, s.length(), result, i);
        i += s.length();
    }

    return new String(result);
}