public static int subSetSum(int i, int k, int A[]) {
    int sum = A[0] + A[1] + A[2];
    int noOfSolutions = 0;
    if(k - sum < 0 || i >= A.length)
        return 0;
    if(k - sum == 0) {
        System.out.println(A[0] + " + " + A[1] + " + " + A[2]);
--(1)-->    noOfSolutions += 1;
--(4)-->    return noOfSolutions;
    }
    noOfSolutions += subSetSum(i+1,k,A);
--(2)-->    A[i] = A[i]+1;
    noOfSolutions += subSetSum(i,k,A);
--(3)-->    A[i] = A[i]-1;
    return noOfSolutions;
}