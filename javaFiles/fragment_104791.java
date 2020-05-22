/**
 * This class will take an integer value, positive or negative, and translate
 * it into printed single digit values.
 * i.e. 142 = one four two
 *      -12 = negative one two
 */

public class NumberTranslator
{

final private static String[] txt = {"zero", "one", "two", "three", "four",
"five", "six", "seven", "eight", "nine"};
static int tempNumber;
static String finalString;
static int tempNumber1;
public static StringBuilder num = new StringBuilder();

public static void main(String[] args)
{
  if(args.length == 0)
  {
    System.out.println("You need to pass a number as an argument");
    return;
  }
  NumberTranslator nt = new NumberTranslator();
  System.out.println(nt.translate(args[0]));
}

public static String translate(int number) {
  return translate(String.valueOf(number));
}

public static String translate(String number) {
  if(!isNumeric(number))
   return "";
  boolean isNegative = false;
  StringBuilder num = new StringBuilder();
  if(number.charAt(0) == '-')
  {
    num.append("negative ");
    isNegative = true;
  }
  if(isNegative)
  {
    number = number.substring(1,number.length());
    for (Character c : number.toCharArray()) {
      num.append(txt[Integer.valueOf(c.toString())]).append(" ");
    }
  }
  else
  {
    for (Character c : number.toCharArray()) {
      num.append(txt[Integer.valueOf(c.toString())]).append(" ");
    }
  }
  return num.toString().trim();
}

private static boolean isNumeric(String value)
{
  //Ignore the negative character
  if(value.charAt(0) == '-')
  {
    for(int i = 1; i < value.length(); i++)
    {
      if(Character.isDigit(value.charAt(i)) == false)
        return false;
    }
  }
  else
  {
    for(int i = 0; i < value.length(); i++)
    {
      if(Character.isDigit(value.charAt(i)) == false)
        return false;
    }
  }
  return true;
}

}