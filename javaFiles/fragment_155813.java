//Cholesky.java
package cfd.optimisation;
//ri, ci, v : matrix row indices, column indices, and values
//y = Ax where A is a nxn matrix with nnz non-zero values
public class Cholesky {
    private static native void solve_eigenLDLTx(int[] ri, int[] ci, double[] v, double[] x, double[] y, int n, int nnz);
}