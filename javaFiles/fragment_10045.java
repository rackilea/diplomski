private static int C1 = 52845;
private static int C2 = 22719;

private static int toUnsignedByte(byte b)
{
    // in Delphi, Byte is an 8-bit unsigned type, but Java does not have
    // an equivalent type. Casting an AnsiChar to a Byte leaves the value
    // as-is as 8 bits. Use a signed integer and limit its value to the
    // same range as a Byte...
    //
    return ((int)b) & 0xFF;
}

public static String EncryptePassword(String S, int Key)
{
    // in Delphi, Word is a 16-bit unsigned type, but Java does not have
    // an equivalent type. Use a signed integer and limit its value
    // to the same range as a Word...
    //
    if ((Key < 0) or (Key > 0xFFFF))
        throw new IllegalArgumentException("Key is outside the valid range of values");

    byte[] Str = S.getBytes(); // <-- you might need to specify a charset to get the correct bytes!
    int J;

    for(int I = 0; I < Str.length; ++I)
    {
        J = toUnsignedByte(Str[I]) ^ (Key >> 8);
        Str[I] := (byte) J;
        Key = ((toUnsignedByte(Str[I]) + Key) * C1 + C2) & 0xFFFF;
    }

    StringBuilder Result = new StringBuilder(Str.length * 3);

    for(int I = 0; I < Str.length; ++I)
    {
        Result.append(String.format(Locale.US, "%03d", toUnsignedByte(Str[I])));
    }

    return Result.toString();
}