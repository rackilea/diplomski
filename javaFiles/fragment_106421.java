public static int counts (byte[] A, byte[] B) {
       int i, count, L=A.length;
       for (count=i=0; i<L; i++)
          count += A[i]==B[i] ? 1 : 0;
       return count;
    }