String someString = "Hello World";
boolean isHelloContained = someString.indexOf("Hello") > -1;
System.out.println(isHelloContained);

someString = "Some other string";
isHelloContained = someString.indexOf("Hello") > -1;
System.out.println(isHelloContained);