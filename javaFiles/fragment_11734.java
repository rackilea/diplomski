public static int readInt24(String input) {
int ret = 0;
if (input.length() >= 3) {
    ret = input.charAt(0) << 16;
    ret |= input.charAt(1) << 8;
    ret |= input.charAt(2) << 0;
}
return ret;
}