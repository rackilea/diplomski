//mocks
@Mock ClassToMock classToMock;
@Mock Logger mockLogger;

//system under test
ClassToTest classToTest;

@Before
public void setUp() throws Exception { 
    MockitoAnnotations.initMocks();
    classToTest = new ClassToTest(classToMock, mockLogger);
}

@Test
public void whenRun_thenDoesSomethingWithSomeParameter() {       
    //act
    classToTest.run();

    //assert
    verify(classToMock).doSomething(eq("some parameter"));
}

@Test
public void givenAnIllegalStateForAClass_whenRun_thenLogsError() {       
    //arrange        
    IllegalStateException e = new IllegalStateException();
    when(classToMock.doSomething(anyString()).thenThrow(e); 

    //act
    classToTest.run();

    //assert
    verify(mockLogger).error(eq("Something bad happened"), same(e));
}

@Test
public void givenAnIllegalStateForAClass_whenRun_thenLogsRecovery() {       
    //arrange        
    when(classToMock.doSomething(anyString()).thenThrow(new IllegalStateException()); 

    //act
    classToTest.run();

    //assert
    verify(mockLogger).info(eq("I am recovering"));
}