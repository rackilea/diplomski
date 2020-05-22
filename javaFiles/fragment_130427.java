public class LetterFactory{
   public static LetterChange getInstance(Object doesNotMatter){
       return doesNotMatter.isA() ? new A() : new B();
   }

   private static class A implements LetterChange{
      public void change(){..}
   }

   private static class B implements LetterChange{
      public void change(){..}
   }
}