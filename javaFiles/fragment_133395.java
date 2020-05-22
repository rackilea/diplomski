Integer[] A = {1, 2, 3, 6, 7, 8, 9, 20, 22};
int start = 0, end;

System.out.print("Numbers ");                 
while((end = start) < A.length){
    // Increment the 'end' pointer while consecutive numbers exist.
    while(end + 1 < A.length && A[end + 1] == A[end] + 1) end++;

    // If end == start: 'A[start]'
    // Else           : 'A[start] through A[end]'
    System.out.print(A[start] + 
                     (end == start ? "":(" through " + A[end])) +  
                     (end < A.length - 1 ? ", ":""));

    // Increment start pointer to next element in A
    start = end + 1;
}