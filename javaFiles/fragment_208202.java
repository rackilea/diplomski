outer i=0
   inner (check [i] vs [j])
        j=1 [0] vs [1]
        j=2 [0] vs [2]
        j=3 [0] vs [3]
        .....
        j=N [0] vs [N] (N is last index) 
    end inner

we've now checked [0] against all other objects and the inner loop finishes
outer loop incrments i

i++
i=1

outer i=1
   inner (check [i] vs [j])
        j=2 [1] vs [2]
        j=2 [1] vs [3]
        j=3 [1] vs [4]
        .....
        j=N [1] vs [N] (N is last index) 
   end inner
....

i++
i=N-1;

outer i=N-1
    inner (check [i] vs [j])
        j=N [N-1] vs [N]
    end inner
end outer