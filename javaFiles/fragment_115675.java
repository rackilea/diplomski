@RunWith(PowerMockRunner.class)
@PrepareForTest({Class1.class})
public class ATestClass {

    private Argument arg;
    private Class1 mockObj1;
    private Class2 mockObj2;

    @Before
    public void initialSetup() {
        PowerMockito.mockStatic(Class1.class);

        mockObj1 = Mockito.mock(Class1.class);

        mockObj2 = Mockito.mock(Class2.class);
    }

    @Before
    public void setupForEachTest() {
        arg = new Argument();
    }

    @Test
    public void testUpdate() throws RemoteException {
        PowerMockito.when(Class1.getDefault()).thenReturn(mockObj1);
        Mockito.when(mockObj1.getClass2()).thenReturn(mockObj2);

        Mockito.when(mockObj2.save(Mockito.any(Argument.class))).thenThrow(new RemoteException());

        Assert.assertFalse(update(arg));
    }
}