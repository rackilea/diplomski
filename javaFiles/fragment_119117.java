class B {

    C c = new C();

    public void method2() throws Exception {
        log.info("I'm method 2 and I'm gonna call method 3");
        c.method3();
        log.info("success");            
    }
}