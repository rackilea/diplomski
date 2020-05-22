@Rule
public ExpectedException exception = ExpectedException.none();

@Test()
public void testFuncB() throws ClassNotFoundException {
    FileClass fc = new FileClass();
    exception.expect(ClassNotFoundException.class);
    fc.funcB();
}