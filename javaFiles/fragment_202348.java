$ cat example.java 

class SOComparison
{

    public static int with_init()
    {
        int x = 0;

        return x;
    }

    public static int later_init()
    {
        int x;

        x = 0;

        return x;
    }

}
$ javap -c SOComparison
Compiled from "example.java"
class SOComparison {
  SOComparison();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static int with_init();
    Code:
       0: iconst_0      
       1: istore_0      
       2: iload_0       
       3: ireturn       

  public static int later_init();
    Code:
       0: iconst_0      
       1: istore_0      
       2: iload_0       
       3: ireturn       
}