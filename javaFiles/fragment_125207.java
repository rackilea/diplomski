private static String rotateLeft(String text, int count) {
    char[] buf = text.toCharArray();
    if (count <= 0 || count >= 26)
        throw new IllegalArgumentException("Invalid count: " + count);
    for (char ch : buf)
        if (ch < 'A' || ch > 'Z')
            throw new IllegalArgumentException("Invalid character: " + ch);
    for (int i = 0; i < buf.length; i++)
        buf[i] = (char)((buf[i] - 'A' + 26 - count) % 26 + 'A');
    return new String(buf);
}

public static void main(String[] args) {
    System.out.println(rotateLeft("VQREQFGT", 2));
    System.out.println(rotateLeft("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10));
    System.out.println(rotateLeft("LIPPSASVPH", 4));
}