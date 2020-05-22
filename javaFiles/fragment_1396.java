public static int getMissingNumber(int[] A) 
 {  
    int n = A.length;  
    boolean[] numbersUsed = new boolean[n + 1]; //Because the definition says 0 <= k <= n, so k = n is also possible.

    for(int k = 0; k < n; k++) 
    {
        if(A[k] <= n && A[k] >= 0) //No negative numbers!
           numbersUsed[A[k]] = true;
    }

    for(int k = 0; k <= n; k++) 
    {
       if(numbersUsed[k] == false) 
          return k;
    } 
    return -1; //nothing found
 }