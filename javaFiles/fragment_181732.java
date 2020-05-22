private static void permute(int[][] arrays)
{
    permute(arrays, 0, new int[arrays.length]);
}

private static void permute(int[][] arrays, int arrayBeingModified, int[] tmp)
{
    if(arrayBeingModified >= arrays.length)
    {
        System.out.println(Arrays.toString(tmp));
    }
    else
    {
        for(int v : arrays[arrayBeingModified])
        {
            tmp[arrayBeingModified] = v;
            permute(arrays, arrayBeingModified + 1, tmp);
            tmp[arrayBeingModified] = 0;
        }
    }
}

public static void main(String[] args)
{
    int[] arr0 = {2,4,8};
    int[] arr1 = {3,6,9,12};
    int[] arr2 = {5,10,15};
    permute(new int[][]{arr0, arr1, arr2});
}