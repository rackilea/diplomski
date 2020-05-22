/*
* Pass one of the arguments. This creates a function accepting three
* arguments.
*/
TriFunction<Integer, Double, Float, Boolean> partiallyApplied = (i, d, f) -> 
                                                           manyArgs("", i, d, f);

/*
* Provide the rest of the arguments
*/
boolean res4 = partiallyApplied.apply(2, 3.0, 4.0F);
System.out.println("No time for ceremonies: " + res4);