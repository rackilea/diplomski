public static double[] convertLongsToDoubles(Long[] input)
{
    if (input == null)
    {
        return null; // Or throw an exception - your choice
    }
    double[] output = new double[input.length];
    for (int i = 0; i < input.length; i++)
    {
        output[i] = input[i];
    }
    return output;
}