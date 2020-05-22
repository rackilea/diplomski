for(int i=Character.MIN_VALUE;i<= Character.MAX_VALUE;i++) {
    String find = new String(new char[] {(char) i});
    String str = new String(new char[] {(char) (i+1), (char) i});
    String str1 = new String(new char[] {(char) (i+1)});

    int test1 = str.indexOf(find);
    if (test1 != 1)
        throw new AssertionError("test1 failed i="+i);

    int test2 = str1.indexOf(find);
    if (test2 != -1)
        throw new AssertionError("test2 failed i="+i);
}