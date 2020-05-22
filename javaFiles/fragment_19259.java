public class Builder
{
   public static void main(String[] args)
   {
      StringBuilder str1 = new StringBuilder("John");
      StringBuilder str2 = new StringBuilder("Que");
      StringBuilder str3 = new StringBuilder("Doe");

      String s = entireName(str1, str2, str3);

      System.out.println(s);
   }

   public static String entireName(StringBuilder s1, StringBuilder s2,
            StringBuilder s3)
   {
        // debugging removed
        return s1.append(s2).append(s3).toString();
   }

}