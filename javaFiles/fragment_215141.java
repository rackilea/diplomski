public static void method(int[] arrayA, int[] arrayB)
{
    boolean match = false;
    label: for(int i = 0; i < arrayA.length; i++)
        for(int j = 0; j < arrayB.length; j++)
            if(arrayA[i] == arrayB[j])
            {
                match = true;
                break label;
            }

    int k = (match?1:0);

    for(int i = 0; i < arrayB.length; i++)
        arrayB[i] = k;
}