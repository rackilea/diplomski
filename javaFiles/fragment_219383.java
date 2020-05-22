package com.drewnoakes.util;

/**
 * Common, generic value conversions.
 *
 * @author Drew Noakes http://drewnoakes.com
 */
public class Convert
{
    private static final char[] _hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @NotNull
    public static String bytesToHex(@NotNull byte[] bytes)
    {
        char[] output = new char[bytes.length * 2];
        for (int i = 0, o = 0; i < bytes.length; i++) {
            byte v = bytes[i];
            output[o++] = _hexArray[(v >>> 4) & 0x0F];
            output[o++] = _hexArray[v & 0x0F];
        }
        return new String(output);
    }

    @NotNull
    public static byte[] hexToBytes(@NotNull String hex)
    {
        return hexToBytes(hex.toCharArray());
    }

    @NotNull
    public static byte[] hexToBytes(@NotNull char[] hex)
    {
        if (hex.length % 2 != 0)
            throw new IllegalArgumentException("Must pass an even number of characters.");

        int length = hex.length >> 1;
        byte[] raw = new byte[length];
        for (int o = 0, i = 0; o < length; o++) {
            raw[o] = (byte) ((getHexCharValue(hex[i++]) << 4)
                            | getHexCharValue(hex[i++]));
        }
        return raw;
    }

    public static byte getHexCharValue(char c)
    {
        if (c >= '0' && c <= '9')
            return (byte) (c - '0');
        if (c >= 'A' && c <= 'F')
            return (byte) (10 + c - 'A');
        if (c >= 'a' && c <= 'f')
            return (byte) (10 + c - 'a');
        throw new IllegalArgumentException("Invalid hex character");
    }
}