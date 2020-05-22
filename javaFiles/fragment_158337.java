//                                                               | escaped " here
String myString = "Hello   Boom,  Ho3w are || You ? Are  ^  you ,\" fr45ee   now ?";
//                 | printing array
//                 |               | splitting "myString"...
//                 |               |               | on 1 or more non-word 
//                 |               |               | characters
System.out.println(Arrays.toString(myString.split("\\W+")));