//Define your class under test without any annotation
private MyServiceImpl serviceToBeTested;

//Create mock dependencies here using @Mocked like below
@Mocked Dependency mockInstance;



@Before
public void setup() {
    //Initialize your class under test here (or you can do it while declaring it also). 
    serviceToBeTested = new MyServiceImpl();

    //Set dependencies via setter (or using mockit.Deencapsulation.setField() method)
    serviceToBeTested.setMyDependency(mockInstance);

    //Optionally add your expectations on mock instances which are common for all tests
    new Expectations() {{
        mockInstance.getName(); result = "Test Name";
        ...
    }};
}

@Test
public void testMyMethod(@Mocked AnotherDependency anotherMock) {
    //Add your expectations on mock instances specifics to this test method.
    new Expectations() {{
        mockInstance.getStatus(); result = "OK";
        anotherMock.longWork(); result = true;
        ...
    }};

    //Set dependencies via setter or using mockit.Deencapsulation.setField() method
    Deencapsulation.setField(serviceToBeTested, "myAnotherDep", anotherMock);

    //Invoke the desired method to be tested
    serviceToBeTested.myMethod();

    //Do the verifications & assertions
    new Verifications() {{
      ....
      ....

    }};

}