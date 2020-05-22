private static <O> ValueValidator<O> newForAlways(Always valid_orInvalid)  {

  ValueValidator<O> vldtr = valid_orInvalid == Always.VALID
     ?  Test.<O>newForAlwaysValid()
     :  Test.<O>newForAlwaysInvalid();
  return  vldtr;
}