public static int foobar( int[] arr)
{
    int noOfCombinations = 0;
    int[] noOfDoubles = new int[arr.length];

    // Count lucky doubles for each item in the array, except the first and last items
    for( int i = 1; i < arr.length-1; ++i)
    {
        for( int j = 0; j < i; ++j)
        {
            if( arr[i] % arr[j] == 0)
                ++noOfDoubles[i];
        }
    }

    // Count lucky triples
    for( int i = 2; i < arr.length; i++)
    {
        for( int j = 1; j < i; ++j)
        {
            if( arr[i] % arr[j] == 0)
                noOfCombinations += noOfDoubles[j];
        }
    }

    return noOfCombinations;
}