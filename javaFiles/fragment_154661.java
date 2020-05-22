@Test 
 public void whenSerialNumberIsEmpty_shouldThrowSerialNumberInvalid() throws Exception {
  try{
     whenRunningSomething_shouldThrowMyExceptionWithInternalErrorCode();     
     fail("should have thrown");
  }
  catch (MyExceptionClass e){
     assertThat(e.getCode(), is(MyExceptionClass.INTERNAL_ERROR_CODE));
  }