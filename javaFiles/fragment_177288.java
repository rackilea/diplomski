public static int reverse(int number) {
    String reverse = "";
    String n = Integer.toString(number); // + " ";
    System.out.println(reverse);
    for (int i = n.length() - 1; i >= 0; i--) {
        reverse += n.charAt(i);
    }

    return Integer.parseInt(reverse);
 }