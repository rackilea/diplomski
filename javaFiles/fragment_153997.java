@Mock
B b;
@Test
public void check(){
  // arrange
  Mockito.when(b.method_b())
        .thenReturn(return_A());
  A a=new A();
  // values to be used by cut in this test
  a.setVal1(1);
  a.setVal3(3); 

  // act
  // assert 
}