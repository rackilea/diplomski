class Test {
         public String toString(){
              return "From test";
         }
  }

  public static void main(String[] args) throws NoSuchMethodException, SecurityException {
    String resut = Test.class.getMethod("toString").getDeclaringClass().getName();
    System.out.println(resut);
}