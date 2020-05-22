public static long parseLong(String s, int radix)
          throws NumberFormatException
{
    if (s == null) {
        throw new NumberFormatException("null");
    }