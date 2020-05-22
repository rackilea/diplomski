public static double parseBinary(String s) {
    int exp = Integer.MIN_VALUE;
    long value = 0;
    for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '.') {
            exp = 0;
        } else {
            value = value * 2 + ch - '0';
            exp++;
        }
     }
     return exp < 0 ? value : Math.scalb(value, -exp); // value * 2^^-exp
}