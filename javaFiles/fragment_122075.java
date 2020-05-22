double[][] A = new double[2][2];
A[0][0] = 1.5;
A[0][1] = 2.5;
A[1][0] = 3.5;
A[1][0] = 4.5;

double[] B = A[0]; // Imagine A[0] as A[i]

/* then value of B is now A[0]
so B is now a unidimensional array containing value:
B[0] == 1.5 == A[0][0]
B[1] == 2.5 == A[0][1] */