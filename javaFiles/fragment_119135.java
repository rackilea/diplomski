string regex = "[0-9]{3}-[0-9]{2}-[0-9]{4}";
if(s.matches(regex))
{
    System.out.println(s + " is a valid social security number");
}else
    System.out.println(s  + " is an invalid social security number");