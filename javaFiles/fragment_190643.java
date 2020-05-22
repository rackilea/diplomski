class A {
 private String field;
 {
   StringBuilder builder = new StringBuilder("Text").append(value)
                                                    .append(" ")
                                                    .append(otherValue);
   //make some computations 
   //append to builder
   //add to field
   field = builder.toString();
 }