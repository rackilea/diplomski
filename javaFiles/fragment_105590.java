@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void testSomething(){
    thrown.expect(ExceptionType.class);
    thrown.expectMessage("Error message");
    thrown.expectCause(is(new CauseOfExeption()));
    thrown.reportMissingExceptionWithMessage("Exception expected"); 
    //any other expectations
    sut.doSomething();
}