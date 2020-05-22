public <T extends Number> T methodX() {
  return (T) someValue;
}

//would compile
Integer i = methodX();

//this would not compile, since s is not a number
String s = methodX();