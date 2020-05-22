static ReadWriteLock rwl = new ReentrantReadWriteLock();

  public static void readFromFile(List<Person> people) {
    rwl.readLock().lock();
    try {
...
      //method body is not changed
    } finally {
      rwl.readLock().unlock();
    }

  }

  public static void writeToFile(List<Person> people) {
    rwl.writeLock().lock();
    try {
...
      //method body is not changed
    } finally {
      rwl.writeLock().unlock();
    }
  }