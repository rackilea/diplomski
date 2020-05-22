public static boolean containsDuplicates(int[] A)
{
    // Create a zero-initialised array the size of the maximum allowed value in A.
    int[] count = new int[maximumValuePossible(A)];

    for (int i = 0; i < A.length; i++)
    {
        if (count[A[i]] != 0)
        {
            // The value at A[i] is already in the histogram -> duplicate!
            return true;
        }

        // A[i] is not in the histogram yet.
        count[A[i]]++;
    }

    return false;
}