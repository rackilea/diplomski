int equi ( int[] A ) {
    int equi = -1;

    long lower = 0;
    long upper = 0;
    foreach (int i in A)
        upper += i;

    for (int i = 0; i < A.Length; i++)
    {
        upper -= A[i];
        if (upper == lower)
        {
            equi = i;
            break;
        }
        else
            lower += A[i];
    }

    return equi;
}