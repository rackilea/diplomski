public static int indexOf(String string, char[] chars) {
    LOOP:
    for (int i = 0; i < string.length() - chars.length; i++) {
        for (int j = 0; j < chars.length; j++)
            if (string.charAt(i + j) != chars[j])
                continue LOOP;
        return i;
    }
    return -1;
}

public static void main(String args[]) {
    char[] chars = "test".toCharArray();
    String one = "qqwtestq";
    String two = "qwqtqwe";
    String str = new String(chars);
    System.out.println("indexOf(" + one+", " + Arrays.toString(chars) + ") = " + indexOf(one, chars));
    System.out.println(one + ".indexOf(" + str + ") = " + one.indexOf(str));
    System.out.println("indexOf(" + two+", " + Arrays.toString(chars) + ") = " + indexOf(two, chars));
    System.out.println(two + ".indexOf(" + str + ") = " + two.indexOf(str));

    char[] chars2 = { '\uffff', '\uFeFF' };
    String test = "qqw\uffff\uFeFFq";
    String str2 = new String(chars2);
    System.out.println("indexOf(" + test+", " + Arrays.toString(chars2) + ") = " + indexOf(test, chars2));
    System.out.println(test + ".indexOf(" + str2 + ") = " + test.indexOf(str2));
}