$ javac Clazz1.java 
Clazz1.java:8: error: non-static variable test cannot be referenced from a static context
    System.out.println("a: " + Clazz1.test.a);
                                     ^
Clazz1.java:8: error: int cannot be dereferenced
    System.out.println("a: " + Clazz1.test.a);
                                          ^