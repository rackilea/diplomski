@Test
public void test1() {

    // ERROR 1
    // This compiles and runs, but it's an invalid use of the framework because 
    // Mockito is still waiting to find out what it should do when myMethod is called.
    // But Mockito can't report it yet, because the call to thenReturn might 
    // be yet to happen.
    when(myMock.method1());

    doSomeTestingStuff();

    // ERROR 1 is reported on the following line, even though it's not the line with
    // the error.
    verify(myMock).method2();

}

@Test
public void test2() {

    doSomeTestingStuff();

    // ERROR 2
    // This compiles and runs, but it's an invalid use of the framework because
    // Mockito doesn't know what method call to verify.  But Mockito can't report 
    // it yet, because the call to the method that's being verified might 
    // be yet to happen.
    verify(myMock);
}

@Test
public void test3() {

    // ERROR 2 is reported on the following line, even though it's not even in 
    // the same test as the error.
    doReturn("Hello").when(myMock).method1();


    // ERROR 3
    // This compiles and runs, but it's an invalid use of the framework because
    // Mockito doesn't know what method call is being stubbed.  But Mockito can't 
    // report it yet, because the call to the method that's being stubbed might 
    // be yet to happen.

    doReturn("World").when(myMock);

    doSomeTestingStuff(); 

    //  ERROR 3 is never reported, because there are no more Mockito calls. 
}