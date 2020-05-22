public static void main(String... ignored) {
    String prev = "";
    for (int i = 0; i < 40000000; i++) {
        String s = asId(i);
        if (s.length() > prev.length())
            System.out.print(prev + "\n" + s + " to ");
        prev = s;
    }
}

static char[] CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

public static String asId(long number) {
    StringBuilder sb = new StringBuilder();
    long div = number < 52 ? 1 : 52;
    while (div <= number / 62) div *= 62;
    while (div > 0) {
        sb.append(CHARS[((int) (number / div % 62))]);
        div /= 62;
    }
    return sb.toString();
}