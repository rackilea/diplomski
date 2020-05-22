public static int toInt(Object obj)
{
      return Integer.parseInt((String) obj);
}



public static void main (String []args)
{
     System.out.println( toInt(tInput()) );
}