try{
    if(count !=0) {
      throw new Exception();
   }else{
    // do something else
   }
}
catch(Exception e){
  eventLogger.logError("The count is not zero",e)
}