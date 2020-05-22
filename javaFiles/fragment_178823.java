@Test
public void testSomeMethod() {
    new NonStrictExpectations(ServiceFactory.class) {{
        ServiceFactory.getImpl(Node.class); result = new NodeImpl();
    }};

    // Call tested code...
}