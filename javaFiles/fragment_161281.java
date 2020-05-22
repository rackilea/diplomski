class Ideone
{
    public static void main(String[] args)
  {
    String text      = "This is = an equal sign";

    Pattern p  = Pattern.compile("(\\w+)\\s?=");
    Matcher matcher  = p.matcher(text);  
    if (matcher.find())
    {
         System.out.println("Match: " + matcher.group(1));
    }
}
}