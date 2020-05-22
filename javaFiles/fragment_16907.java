public static String reverseEachWord(String s1) {

    s1 = s1 + " ";
    String s2 = "";
    int i = 0;
    char ch;
    String temp = "";
    while (i < s1.length()) {

        while (s1.charAt(i) != ' ') {
            temp = temp + s1.charAt(i);
            i++;
        } 
        temp = reverse(temp);
        s2 = s2 + temp;
        temp = "";
        i++;

    }

    return s2;

}