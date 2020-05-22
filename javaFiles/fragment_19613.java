Compiled from "ArtClass.java"
public class ArtClass {
  public ArtClass();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public boolean foo(int);
    Code:
       0: iload_1
       1: ldc           #2                  // int 3956681
       3: if_icmpne     8
       6: iconst_1
       7: ireturn
       8: iload_1
       9: ldc           #3                  // int 9855021
      11: if_icmpne     16
      14: iconst_1
      15: ireturn
      16: iload_1
      17: ldc           #4                  // int 63085561
      19: if_icmpne     24
      22: iconst_1
      23: ireturn
      24: iconst_0
      25: ireturn
}