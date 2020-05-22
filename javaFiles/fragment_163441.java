@Transactional(propagation = Propagation.REQUIRES_NEW)
public void serviceMethod() {}

@Transactional(propagation = Propagation.REQUIRED)
public void daoMethod1() {}

@Transactional(propagation = Propagation.REQUIRED)
public void daoMethod2() {}