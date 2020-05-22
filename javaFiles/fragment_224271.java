public <T> T methodX() {
  return (T) someValue; //Note that you should ensure that this cast succeeds or catch the possible ClassCastException here
}

//call it like this:
String s = methodX();