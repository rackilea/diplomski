WorkResult doWork(SharedObject so) {
    Data data = so.loadData();
    WorkResult wr = doSomeLengthyWork(data);
    return wr;
  }

  void update(WorkResult wr, SharedObject so) {
    so.updateFromWorkResult( wr );
  }