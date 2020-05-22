@Test
public void myClassSub() throws Exception {
    Class<?> cl = Class.forName("miscellaneous.so.myclass.MyClassSub");
    MyClass myObject = (MyClass) cl.getConstructor().newInstance();
    // Note that here the reference is asserted to be null
    Assert.assertNull(myObject.fu);

    myObject = (MyClass) cl.getConstructor().newInstance();
    myObject.myMalloc();
    Assert.assertNotNull(myObject.fu);
}