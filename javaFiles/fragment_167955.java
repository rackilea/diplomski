@Test
public void myClass() throws Exception {
    Class<?> cl = Class.forName("miscellaneous.so.myclass.MyClass");
    MyClass myObject = (MyClass) cl.getConstructor().newInstance();
    Assert.assertNotNull(myObject.fu);

    myObject = (MyClass) cl.getConstructor().newInstance();
    myObject.myMalloc();
    Assert.assertNotNull(myObject.fu);
}