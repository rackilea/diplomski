public class Foo
{  
   private static Pattern pattern = Pattern.compile(" ");
   public static void main(String[] args)
   {  
         String test = "Cats go meow";  
         String[] tokens = pattern.split(test);
   }
}