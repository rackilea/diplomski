public class Test {

    // not autowired here
    private A a;

    private B mockB;

    @Test
    public void testA() {
        mockB = mock(B.class);
        when(b.bFn(), anyInt()).thenReturn(something);

        // the missing part: injecting the mock into the tested object
        a = new A(mockB);
        // or a = new A();
        //    a.setB(mockB);

        assertEquals(0, a.aFn());
    }
}