static int length(String p) {
    int i = 0;
    try {
        while (i <= i) {
            char ch = p.charAt(i);
            i++;
        }
    } catch (StringIndexOutOfBoundsException e) { // catch specific exception
      // exception caught here
    }
    return i; // now i is the length 
}


public static void main(String s[]) {
    String a = "jack";
    System.out.println(length(a));
}