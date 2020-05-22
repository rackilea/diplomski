public class A {

   private B b;

   public B getB() {
     return b;
   }

   public static class B {
      String day;
      HashMap<String, ArrayList<Date>> locationTimes;

      public B() { 
          locationTimes = new HashMap<String, ArrayList<Date>>();
          day = "Monday"
      }

      public String getDay() {
        return day;
      }
  }
}