String capital = stateMap.get(testValue);
if (capital == null) {
   // error message
   System.err.printf("%s is not a valid state, please try again%n", testValue);
} else {
   // output a valid result
   System.out.printf("The capital of %s is %s%n", testValue, capital);
}