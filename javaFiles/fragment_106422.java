public static int counts (byte[] A, byte[] B) {
        final int S=8;
        int i, count, L=A.length-S;
        for(count=i=0; i<L; i+=S) {
            count += A[i+0]==B[i+0] ? 1 : 0;
            count += A[i+1]==B[i+1] ? 1 : 0;
            count += A[i+2]==B[i+2] ? 1 : 0;
            count += A[i+3]==B[i+3] ? 1 : 0;
            count += A[i+4]==B[i+4] ? 1 : 0;
            count += A[i+5]==B[i+5] ? 1 : 0;
            count += A[i+6]==B[i+6] ? 1 : 0;
            count += A[i+7]==B[i+7] ? 1 : 0;
        }
        for (; i<L+S; ++i)
            count += A[i]==B[i] ? 1 : 0;
        return count;
    }