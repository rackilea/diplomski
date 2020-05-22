boolean checkContained(int[] inner, int[] outer)
{
    int i = 0;
    for(int j = 0; j < inner.length; j++)
    {
        while(i < outer.length && outer[i] < inner[j])
        {
             i++;
        }
        if(i >= outer.length || outer[i] != inner[j])
        {
             return false;
        }
    }
    return true;
}