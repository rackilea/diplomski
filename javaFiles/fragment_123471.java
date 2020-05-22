SimpleMatrix A = new SimpleMatrix(10,5);

    LUDecomposition<DenseMatrix64F> lu = DecompositionFactory.lu(A.numCols());

    if( !lu.decompose(A.getMatrix()) ) {
        throw new RuntimeException("LU Decomposition failed!");
    }

    SimpleMatrix L = SimpleMatrix.wrap(lu.getLower(null));
    SimpleMatrix U = SimpleMatrix.wrap(lu.getUpper(null));