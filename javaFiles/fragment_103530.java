public boolean isSatisfied(int[] arr) 
{
    for (int i = 0; i < arr.length; i++) 
    {
        if ((i + arr[i]) % 2 != 0)
            return false;
    }
    return true;
}