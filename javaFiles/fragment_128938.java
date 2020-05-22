Compiled from "WideInstruction.java"
class WideInstruction {
  public static void largeIncrement(int);
    Code:
       0: iinc_w        0, 1000
       6: return

  public static int largeVarIndex();
    Code:
       0: bipush        42
       2: istore_w      256
       6: iload_w       256
      10: ireturn

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #1                  // Method decompile:()V
       3: return
}