private final    byte[][][] cacheF = new ...;  // dimensions fixed?
  private volatile byte[][][] cacheV = cacheF;

  public byte[] getData(int row, int col)
  {
    return cacheV[row][col];
  }

  public void updateData(int row, int col, byte[] data)
  {
    synchronized(cacheF)
    {
      if (!Arrays.equals(data,cacheF[row][col]))
      {
        cacheF[row][col] = data;

        cacheV = cacheF; 
      }
    }
  }