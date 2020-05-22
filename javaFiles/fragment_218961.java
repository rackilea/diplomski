class  MySecurityManager extends SecurityManager{
  public void checkAccess(Thread t) {
    super.checkAccess(t);
    if (t.getId()==0) {// a hack to determine if we are in thread's constructor
       return; 
    }
    if (t==Thread.currentThread()) {
      return; // thread always can modify itself
    }
    if (t is non-modifiable) {
      throw new SecurityException();
    }
  }