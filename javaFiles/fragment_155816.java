//y = A x: x and y are double[] arrays and A is DoubleMatrix2D
int nnz = A.cardinality();
DoubleArrayList v = new DoubleArrayList(nnz);
IntArrayList ci = new IntArrayList(nnz);
IntArrayList ri = new IntArrayList(nnz);

A.forEachNonZero((row, column, value) -> {
    v.add(value); ci.add(column); ri.add(row); return value;}
);

Cholesky.solve_eigenLDLTx(ri.elements(), ci.elements(), v.elements(), x, y, n, nnz);