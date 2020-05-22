@Mock
Object1 ob1;

@Mock
Object2 ob2;

@InjectMocks
A a = new A();

@Test
public void ATest(){
    A spy = spy(a);

    doReturn(true).when(spy).method2();

    Object3 ob3;
    when(ob1.someMethod()).thenReturn(someObject);
    when(ob2.someMethos()).thenReturn(someOtherObject);

    ob3 = spy.methodToBeTested();

    assertNotNull(ob3);
}