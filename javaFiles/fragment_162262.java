static byte[] intsToBytes(int[] ints)
{
    byte[] bytes = new byte[ints.length];
    for (int i = 0; i < ints.length; i++)
    {
        if (ints[i] < 0 || ints[i] > 255) System.out.println(String.format("WARNING: ints at index %1$d (%2$d) was not a valid byte value (0-255)", i, ints[i]));

        bytes[i] = (byte)ints[i];
    }

    return bytes;
}

static int[] bytesToInts(byte[] bytes)
{
    int[] ints = new int[bytes.length];
    for (int i = 0; i < bytes.length; i++)
    {
        ints[i] = bytes[i] & 0xff;
    }

    return ints;
}