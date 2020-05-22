static void f (String str, int n) {
    if (n > str.length ()) return;
    String temp = str.substring (0, n); // obtain the string
    System.out.println (temp); // print
    f (str, n + 1); // go to next substring
    System.out.println (temp); // print after returning from the last obtainable substring
}