public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

  Method method = Test.class.getMethod("myFunction");

  boolean didwork = retry(method, 5);
  if (didwork) {
      System.out.println("I found my stuff");
  } else {
      System.out.println("I didn't found my stuff");
  }

}

public static boolean retry(Method method, int loopTry)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

  boolean success = false;
  for (int i = 0; i < loopTry; i++) {
    success = (Boolean) method.invoke(null);
    if (success) {
      break;
    }
  }
  return success;
}

public static boolean myFunction() {
  boolean found = false;

  //do stuff
  if(stuff){
     found = true;
  }

  return found;
}