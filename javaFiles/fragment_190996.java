public int [] change(int[] in)
{
    int outLength = 0;
    for(int i = 0; i < in.length; i++)
    {
        if(in[i] % 2 != 0)
        {
            outLength++;
        }
    }

    int[] out = new int[outLength];
    int counter = 0;
    for(int i = 0; i < in.length; i++)
    {
        if(in[i] % 2 != 0)
        {
            out[counter] = in[i];
            counter++;
        }
    }

    return out;
}