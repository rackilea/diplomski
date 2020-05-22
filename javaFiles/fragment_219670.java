public class Test
{
   public static void main(String[] args)
   {
       String s = "GT|!ll22";
       if(!s.matches("[*| ]+"))
           System.out.println("Incorrect");
   }
}