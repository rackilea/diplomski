public static String[] trees(int[] input) 
{
    W = input[0];
    H = input[1];

    int x1, x2, y1, y2;

    for (int i = 2; i < input.length-3; i+=4) 
    {
        x1 = input[i];
        x2 = input[i + 1];
        y1 = input[i + 2];
        y2 = input[i + 3];

        StdOut.println(x1 + x2 + y1 + y2);
    }
    return null;
}