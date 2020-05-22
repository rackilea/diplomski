CalculInteretsParameters params = new CalculInteretsParameters();
 params.setTauxWithMarge(1.0);  //  set all your dates, numbers and parameters
 params.setPeriodicite(2);
 ...

 // then call your method (maybe even with some dynamic values)
 calculInteretsParPeriode(params, someDynamicValue);