public static int[] convertToIntArray(byte[] input)
{
    int[] ret = new int[input.length];
    for (int i = 0; i < input.length; i++)
    {
        ret[i] = input[i] & 0xff; // Range 0 to 255, not -128 to 127
    }
    return ret;
}