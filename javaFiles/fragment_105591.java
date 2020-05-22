@Test
public void testSomething(){
    try{
        sut.doSomething();
        fail("Expected exception");
    } catch(ExceptionType e) {
    //assert ExceptionType e
    } 
}