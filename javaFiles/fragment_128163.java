class SubClass extends BaseClass {
    SubClass(SubFactory factory) {
        super(factory);
    }

    SubFactory getFactory() { return factory; }

    public void parse() {
       getFactory().createSomething();
    }
}

class SubTest {

  @Mock
  SubFactory subFactory;

  @Mock
  Something something;

  @Mock
  SubCreation someSubCreation;

  SubClass subject = new SubClass(subFactory);

  public void setUp() {
    when(subFactory.createSomething()).thenReturn(someSubCreation);
  }

}