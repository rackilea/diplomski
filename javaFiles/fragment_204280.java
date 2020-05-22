class Sub extends Super {
  private static String massageArgument(String incoming) { 
    return incoming.replaceAll("foo", "bar"); 
  }

  public Sub(String incoming) {
    super(massageArgument(incoming));
  }