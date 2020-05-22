public static int solution(int[] A){
    Arrays.parallelPrefix(A, Integer::sum);        
    System.out.println(Arrays.toString(A));
    int min = Integer.MAX_VALUE;
    for(int i = 0; i< A.length-1; i++){
        if(Math.abs(A[i]-A[A.length-1]+A[i]) < min){
            min = Math.abs(A[i]-A[A.length-1]+A[i]);
        }
    }
    return min;
}