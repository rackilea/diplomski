public class ValueOfDemo2 {
  public ValueOfDemo2();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String 1.5
       2: invokestatic  #3                  // Method java/lang/Float.valueOf:(Ljava/lang/String;)Ljava/lang/Float;
       5: invokevirtual #4                  // Method java/lang/Float.floatValue:()F
       8: fstore_1
       9: return
}