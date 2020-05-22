@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class SomeServiceTest {

    @Test
    public void myTest() {
        SomeInterface myInterfaceMock = mock(SomeInterface.class);
        SomeService myService = new SomeService(myInterfaceMock);

        doReturn(1).when(myInterfaceMock).doSomething(1);
        doReturn(2).when(myInterfaceMock).doSomething(2);
        doReturn(3).when(myInterfaceMock).doSomething(3);

        int sum = myService.callInterface(1, 2, 3);

        assertEquals(1 + 2 + 3, sum);

        verify(myInterfaceMock).doSomething(1);
        verify(myInterfaceMock).doSomething(2);
        verifyNoMoreInteractions(myInterfaceMock);

    }

}