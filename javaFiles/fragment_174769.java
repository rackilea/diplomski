class Main
{
  public static void main (String[] args) throws java.lang.Exception
  {
     String test = "testing 1 2 3 <a title=\"a demo\" href=\"\">testing 4 5 6</a> testing\t7\n8\r9 <br /><script src=\"blah\" />more text";
     java.util.regex.Matcher m = java.util.regex.Pattern.compile("(<(?<tag>[A-Za-z]+)[^>]*?>[^<]*</\\k<tag>>)|(<[A-Za-z]+[^>]*?/>)|([^\\p{Space}]+)").matcher(test);
     while(m.find())
        System.out.println(m.group());
  }
}