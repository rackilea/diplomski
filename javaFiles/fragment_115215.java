MyClass{

    @Transactional
    public void sequence() {
      method1();
      method2();
    }

    @Transactional
    void method1() {
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    void method2() {
    }

}