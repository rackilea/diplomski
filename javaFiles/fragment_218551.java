String s = "1111111111111111111111111111111111111111111111111111111111111111";
long res;
if (s.length() < 64) {
    res = Long.parseLong(s, 2);
} else {
    res = Long.parseLong(s.substring(1), 2);
    if (s.charAt(0) == '1') {
        res |= (1L << 63);
    }
}