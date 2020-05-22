import java.util.Scanner;

public class QuestionTwo

{

  public static void main(String[] args)
  {
    Integer number;

    String first, middle, last;

    Scanner keyboard = new Scanner (System.in);

    System.out.print("First name: ");

    first = keyboard.next();

    System.out.print("Middle name: ");

    middle = keyboard.next();

    System.out.print("Last name: ");

    last = keyboard.next();

    System.out.print("Which type of sort order would you like (1 for ascending and 2 for descending)? ");

    number = keyboard.nextInt();

    int firstLength = first.length();
    int middleLength = middle.length();
    int lastLength = last.length();

    if(number == 1)
    {
      System.out.println("Sort order: 1");

  if(firstLength < middleLength && firstLength < lastLength)
  {

    if(middleLength < lastLength)
    {

      System.out.println (first + " " + middle + " " + last);
    }

    if(lastLength < middleLength)
    {

      System.out.println (first + " " + last + " " + middle);
   }
  }

  if(middleLength < firstLength && middleLength < lastLength)
  {

    if(firstLength < lastLength)
    {

      System.out.println (middle + " " + first + " " + last);
    }

    if(lastLength < firstLength)
    {

      System.out.println (middle + " " + last + " " + first);
    }
  }

  if(lastLength < middleLength && lastLength < firstLength)
  {

    if(middleLength < firstLength)
    {

      System.out.println(last + " " + middle + " " + first);
    }

    if(firstLength < middleLength)
   {

     System.out.println(last + " " + first + " " + middle);
    }
  }
}

if(number == 2)
{

  System.out.println("Sort order: 2");

   if(firstLength > middleLength && firstLength > lastLength)
  {

    if(middleLength > lastLength)
    {

      System.out.println (first + " " + middle + " " + last);
    }

    if(lastLength > middleLength)
    {

      System.out.println (first + " " + last + " " + middle);
    }
  }

  if(middleLength > firstLength && middleLength > lastLength)
  {

    if(firstLength > lastLength)
    {

     System.out.println (middle + " " + first + " " + last);
    }

    if(lastLength > firstLength)
    {

      System.out.println (middle + " " + last + " " + first);
    }
  }

  if(lastLength > middleLength && lastLength > firstLength)
 {

    if(middleLength > firstLength)
    {

      System.out.println(last + " " + middle + " " + first);
    }

    if(firstLength > middleLength)
    {

      System.out.println(last + " " + first + " " + middle);
    }
  }
}
}
}