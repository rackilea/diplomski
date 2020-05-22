Compiled from "A.java"
final class A$1 implements A$Adapter<java.lang.Double> {
  A$1();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public java.lang.Double adapt(java.lang.String);
    Code:
       0: aload_1
       1: invokestatic  #2                  // Method java/lang/Double.valueOf:(Ljava/lang/String;)Ljava/lang/Double;
       4: areturn

  public java.lang.Object adapt(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: invokevirtual #3                  // Method adapt:(Ljava/lang/String;)Ljava/lang/Double;
       5: areturn
}