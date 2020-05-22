synchronized (appleLock) {
       //this line requires a lock on license manager, and this lock is not 
       //available because is hold by the other thread waiting to get the appleLock
       logger.info("Using apple. Apples left: " + apples);

       if (apples == 0) throw new InsufficientApplesException();
       apples--;
  }