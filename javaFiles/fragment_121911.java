SomeObject someObject1 = new SomeObject();
  SomeObject someObject2 = new SomeObject();

  @Before
  public void setup() {
    someObject1.setId(123456);
    someObject2.setId(123457);
    when(mockSomeService.getSomeObject).thenReturn(someObject1);
    when(mockSomeService.getSomeObject.getNextFunc.getOtherObject).thenReturn(someObject2);
    //...
  }
  //...
}