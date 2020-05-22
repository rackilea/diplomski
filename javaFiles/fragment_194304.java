if(count !=0) {
  Exception e = new Exception();
  eventLogger.logError("The count is not zero",e)
  throw e;
}
else{
    // do something else
}