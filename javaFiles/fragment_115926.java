public class MyClass {
    public List<String> myMethod(String name) throws IOException {
        List<String> result = myPrivateMethod("a", "b");
        result.addAll(myPrivateMethod("c", "d"));
        return result;
    }

    private List<String> myPrivateMethod(String a, String b) {
        List<String> r = new ArrayList<>();
        r.add(a);
        r.add(b);
        return r;
    }
}

@Test
public void testMyMethod() throws Exception {
    MyClass myClass = PowerMockito.spy(new MyClass());

    PowerMockito.doReturn(new ArrayList<String>(){{add("temp");}})
        .when(myClass, "myPrivateMethod", "a", "b");

    PowerMockito.doReturn(new ArrayList<String>())
        .when(myClass, "myPrivateMethod", "c", "d");

    List<String> list = myClass.myMethod("someName");
    assertEquals(1, list.size());
    assertEquals("temp", list.get(0));
}