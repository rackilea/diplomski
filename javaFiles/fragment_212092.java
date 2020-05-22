public class sad
{
    // instance variables - replace the example below with your own
    private String stringwords;

    /**
     * Constructor for objects of class sad
     */
    public sad()
    {
        stringwords = "this is some words a cat";
    }

    //
    public void search()
    {
      int a = stringwords.indexOf("a");
           System.out.println(a);
    }