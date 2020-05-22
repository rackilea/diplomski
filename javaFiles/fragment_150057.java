abstract class FooForTest implements Foo {

    public static Foo create() {
        FooForTest mockFoo = mock(FooForTest.class);
        mockFoo.map = new HashMap<>();
        when(mockFoo.get(any())).thenCallRealMethod();
        doCallRealMethod().when(mockFoo).add(any(), any());
        return mockFoo;
    }        

    Map<Object, Object> map = new ...

    @Override
    void add(Object key, Object value) {
        map.put(key, value);
    }

    @Override
    Object get(Object key) {
        map.get(key);
    }
}