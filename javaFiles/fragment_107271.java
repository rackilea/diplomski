@Before  
  public void setup() {
    ...
  }

  @Test
  public void test1() {
    when(c2.foo(input1)).thenReturn(out1); 
  }

  @Test
  public void test2() {
    when(c2.foo(input2)).thenReturn(out2); 
  }