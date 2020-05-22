public void myMethod() throws SpaceInvadersException
{
  /* Code that might throw an exception */
}

public void callingMethod()
{
  try {
    myMethod();
  }
  catch (SpaceInvadersException exception) {
    /* Complicated error handling code */
  }
}