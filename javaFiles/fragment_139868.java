public class BaseObjFactory {
   public static BaseObj create(String name, int value) {
      return new Sample2(name, value);
   }

   public static BaseObj create(String name, float value) {
      return new Sample1(name, value);
   }
}