class Object1Test {
    @Test
    public void testMethod1() {
        Object1 object1 = new Object1();
        object1.setObject2(/* Pass your mocked object here */);
        object1.method(); // want to run this method without invoking Object2
    }
}