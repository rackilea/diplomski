class vecGenUn
{
  double[][] prevMat;
  RealMatrix matrixSim;  //this is problematic
  int dataDim;
  int rowDim;
  double simVecMean;
  double simVecSD;
  double simVecUn;
  double sum;

  vecGenUn (double[][] tempPM)
  {
    prevMat = tempSM; // (*) tempSM is undefined
    matrixSim = new Array2DRowRealMatrix(prevMat);  //and possibly this
    dataDim = new int matrixSim.getColumnDimension(); // (*) 'new int' is invalid
    rowDim = new int matrixSim.getRowDimension(); // (*) ditto
    simVecMean = new double[dataDim]; // (*) assigning an array to a scalar variable
    simVecSD = new double[dataDim]; // (*) ditto
    simVecUn = new double[dataDim]; // (*) ditto
    sum = new Sum(); // (*) assigning object to primitive
  }

  public void vecGen()
  {
    for (int i = 0; i < dataDim; i++)
    {
      simVecMean[i] = sum.evaluate(matrixSim.getColumn(i), 0, rowDim)/rowDim // (*) indexing a scalar variable
    }
  }
}