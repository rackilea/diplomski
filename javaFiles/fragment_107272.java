@Before  
  public void setup() {
    when(c2.foo(input1)).thenReturn(out1); 
    when(c2.foo(input2)).thenReturn(out2);
  }

  @Test
  public void test1() {
    // do something
  }

  @Test
  public void test2() {
    // do something
  }