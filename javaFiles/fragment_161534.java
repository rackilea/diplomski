class Example {
  public static void main(String[] args) {
    try {
       outerFunction();
    }
    catch (Throwable e) {
       System.err.println("Outside:");
       e.printStackTrace();
    }
  }
  static void outerFunction() throws Throwable {
    try {
       innerFunction();
    } 
    catch(Exception e) {
       System.err.println("Inside:");
       e.printStackTrace();
       throw e.fillInStackTrace();
    }
  }
  static void innerFunction() {
     throw new RuntimeException("A custom exception");
  }
}