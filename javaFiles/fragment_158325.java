public void doTheThing(SomeParameter sp) throws SpecificRuntimeException {
  ValidBean validbean = isValidParam(sp); 
  if (! validBean.isValid()) {
      throw validBean.getExceptionOnInvalid();
  }
  ...
}