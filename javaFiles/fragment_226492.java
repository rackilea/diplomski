private airfoil myAirfoil = new airfoil();   
// does not compile - no non-arg constructor available

...

new airfoil(numNaca);    
// does not compile - numNaca is int, constructor expects String