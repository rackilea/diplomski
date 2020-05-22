public int solution(int[] A) {
    int mul = 0;
    int cnt = 0;
    for(int i = 0 ; i<A.length ; i++){
        if(A[i] == 0) mul++;
        else cnt = cnt+mul;

        if(cnt>1000000000) return -1;
    }

    return cnt;
}