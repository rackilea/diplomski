@Override
  public int getRowCount()
  {
    int result = 0;
    synchronized(LOCK) {
      if(movies != null) {
        result = movies.size();
      } // if
    } // synchronized
    return result;
  }