Compiled from "Foo.java"
class Foo {
  Foo();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void main(java.lang.String[]);
    Code:
       0: iconst_0      
       1: istore_2      
       2: iload_2       
       3: ldc           #2                  // String 1-2-3
       5: ldc           #3                  // String \D
       7: invokevirtual #4                  // Method java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
      10: arraylength   
      11: if_icmpge     20
      14: iinc          2, 1
      17: goto          2
      20: return        
}