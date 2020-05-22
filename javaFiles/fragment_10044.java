private static int C1 = 52845;
private static int C2 = 22719;

private static int toUnsignedByte(char c)
{
    // in Delphi, Byte is an 8-bit unsigned type, but Java does not have
    // an equivalent type. Casting a Char to a Byte truncates the value
    // to 8 bits. Use a signed integer and limit its value to the
    // same range as a Byte...
    //
    return ((int) c) & 0xFF;
}

public static String EncryptePassword(String S, int Key)
{
    // in Delphi, Word is a 16-bit unsigned type, but Java does not have
    // an equivalent type. Use a signed integer and limit its value
    // to the same range as a Word...
    //
    if ((Key < 0) or (Key > 0xFFFF))
        throw new IllegalArgumentException("Key is outside the valid range of values");

    int J;
    StringBuilder Str = new StringBuilder(S);

    for(int I = 0; I < S.length(); ++I)
    {
        J = toUnsignedByte(S.charAt(I)) ^ (Key >> 8);
        Str.setCharAt(I, (char) J);
        Key = ((toUnsignedByte(Str.charAt(I)) + Key) * C1 + C2) & 0xFFFF;
    }

    StringBuilder Result = new StringBuilder(S.length() * 3);

    for(int I = 0; I < S.length(); ++I)
    {
        Result.append(String.format(Locale.US, "%03d", toUnsignedByte(Str.charAt(I))));
    }

    return Result.toString();
}