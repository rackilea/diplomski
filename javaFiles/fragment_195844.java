public static void main(String [ ] args)
{
   createLockIfNotExists();
   try {
       yourstuff;
   } finally {
     releaseLock();
   }
}
private static void createLockIfNotExists() throws MyLockAlreadyExists {
  // A bit tricky
  // check if LOCKFILE exists, if yes throw MyLockAlreadyExists
  // try to create LOCKFILE, can fail if at 1 ms earlier an other app created
  // that file, so an exception while creating also results in LockAlreadyExists
}