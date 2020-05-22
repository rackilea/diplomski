bool matchesAlmost(String str1, String str2) {
    if (str1.length != str2.length)
        return false;
    int same = 0;
    for (int i = 0; i < str1.length; ++i) {
        if (str1.charAt(i) == str2.charAt(i))
            same++;
    }
    return same == str1.length - 1;
}