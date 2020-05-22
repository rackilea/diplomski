static int[] codePoints(final String s)
{
    final int len = s.length();
    final int[] ret = new int[s.codePointCount(0, len)];
    int nrCodePoints = 0;
    int codePoint;
    int index;
    for (index = 0; index < len; index++) {
        codePoint = s.codePointAt(index);
        ret[nrCodePoints++] = codePoint;
        if (codePoint > Character.MAX_VALUE)
            index++;
    }
    return ret;
}