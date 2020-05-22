static void sort(int A[])
    {
         for(int j = 1; j < A.length; j++)
         {
            int key = A[j];
            int i = j;
            while(i > 0 && A[i-1] > key)
            {
                A[i] = A[i-1];
                i--;
            }
            A[i] = key;
         }
    }