int[] A = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2}; // any number and values will work!

int max = IntStream.of(A).max().getAsInt(); // gets max value in array
int[] counter = new int[max + 1]; 
for (int i = 0; i < A.length; ++i)
    counter[A[i]]++;