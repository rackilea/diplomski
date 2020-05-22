import java.util.*;

public class LambdaTest     
{
    public static void main (String[] args)
    {

         String[] st = "Hello".split("");
         Collection myList = Arrays.asList(st);
         System.out.println("your word has " + myList.stream().count() + "letters");

    } 
}