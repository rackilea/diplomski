public static void niko(byte[] data, StringBuilder sb)
{
    for (byte element : data) {
        sb.append(toChar((element & 0xf0) >>> 4));
        sb.append(toChar(element & 0x0f));
    }
}

static char toChar(int b) {
    int offset = b < 10 ? 48 : 87;
    return (char) (b + offset);
}