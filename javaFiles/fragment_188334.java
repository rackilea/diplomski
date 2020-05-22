public synchronized void addBatch()
    throws SQLException
  {
    if (this.batchedArgs == null) {
      this.batchedArgs = new ArrayList();
    }

    for (int i = 0; i < this.parameterValues.length; ++i) {
      checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
    }

    this.batchedArgs.add(new BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
  }