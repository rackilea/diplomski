int n = A.length;
for(int i = 0; i < n; i++)
    for(int j = 0; j < n; j++)
        if(i != j)
            if(A[i] * A[j] == 225)
                return true;