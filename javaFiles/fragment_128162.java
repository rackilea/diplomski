@Override
protected JndiRegistry createRegistry() throws Exception {
    JndiRegistry jndi = super.createRegistry();

    //use jndi.bind to bind your beans

    return jndi;
}

@Test
public void test() {
    //perform test
}