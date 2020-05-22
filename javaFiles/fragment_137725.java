public static int[] convertToIntArray(byte[] input)
{
    int[] ret = new int[input.length];
    for (int i = 0; i < input.length; i++)
    {
        ret[i] = input[i];
    }
    return ret;
}