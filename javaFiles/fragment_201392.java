public void test1() {
    TestObject to = new TestObject();
    to = test2(to); // THIS line, to receive the object you created in test2()
    to.printValues();

    TestObject to2 = null;
    to2 = test2(to2);
    to2.printValues();
}