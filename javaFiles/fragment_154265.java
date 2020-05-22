for(int i=0;i<m;i++)
  {
      for(int j=0;j<n;j++)
      {
          A1.setRow(i, j, A2[i][j]);
          double value1 = A1.get(i,j);
          System.out.print(" "+value1);
          // System.out.println();
      }
      b1.setRow(i,0, B2[i]); 
      double value2 = b1.get(i,0);
      System.out.print(" = "+value2);
      System.out.println();
  }


  try {
      SimpleMatrix x1 = A1.solve(b1);
      for(int i=0;i<x1.getNumElements();i++)
      {
          double value = x1.get(i, 0);
          System.out.println(" value of x"+i+" is "+value);
      } 
  } 
  catch ( SingularMatrixException e ) 
  {
    //  throw new IllegalArgument("Singular matrix");
  }