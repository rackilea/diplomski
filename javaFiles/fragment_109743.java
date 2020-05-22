private SomeClass attribute;
private SomeOtherClass testClass;

@Before
public void setUp() {
    PowerMockito.mockStatic(StaticClass.class);
    Mockito.when(StaticClass.staticMethod(anyString())).thenReturn(new SomeConcreteClass());

    attribute = Mockito.mock(SomeClass.class);      
    testClass = new SomeOtherClass();

    // assign mock manually
    testClass.attribute = attribute;
}