@AfterThrowing(
    pointcut =
      "execution(*myClass.myDataProcessingMethod(..))",
    throwing = "ex"
  )
public void myAspectMethod(Exception ex) {
  if(!ex instanceof Myexception){
      extraInformingService.informAdamAtOnce("shitjustgotreal");
  }
}