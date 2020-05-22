public class test.T {
  int a;

  public test.T();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0       
       5: iconst_0      
       6: putfield      #2                  // Field a:I
       9: getstatic     #3                  // Field     java/lang/System.out:Ljava/io/PrintStream;
      12: aload_0       
      13: getfield      #2                  // Field a:I
      16: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      19: return        

  public static void main(java.lang.String[]);
    Code:
       0: new           #5                  // class test/T
       3: dup           
       4: invokespecial #6                  // Method "<init>":()V
       7: pop           
       8: return        
}