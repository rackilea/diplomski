public int solution(int[] A) {
        Arrays.sort(A);
        int k, count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            k = i + 2;
            for (int j = i + 1; j < A.length; j++) {
                for( ; k < A.length; k++) {
                    if ( (A[i] + A[j]) <= A[k]) break;
                }
                count += k - j - 1;
            }
        }
        return count;
    }