$ javap -c LoopStyle.class 
Compiled from "LoopStyle.java"
public class SO37060005.LoopStyle {
  int q;

  int i;

  int r;

  int charPos;

  int[] digits;

  int[] buf;

  public SO37060005.LoopStyle();
    Code:
       0: aload_0
       1: invokespecial #16                 // Method java/lang/Object."<init>":()V
       4: return

  public void loop1();
    Code:
       0: aload_0
       1: aload_0
       2: getfield      #23                 // Field i:I
       5: ldc           #25                 // int 52429
       7: imul
       8: bipush        19
      10: iushr
      11: putfield      #26                 // Field q:I
      14: aload_0
      15: aload_0
      16: getfield      #23                 // Field i:I
      19: aload_0
      20: getfield      #26                 // Field q:I
      23: iconst_3
      24: ishl
      25: aload_0
      26: getfield      #26                 // Field q:I
      29: iconst_1
      30: ishl
      31: iadd
      32: isub
      33: putfield      #28                 // Field r:I
      36: aload_0
      37: getfield      #30                 // Field buf:[I
      40: aload_0
      41: dup
      42: getfield      #32                 // Field charPos:I
      45: iconst_1
      46: isub
      47: dup_x1
      48: putfield      #32                 // Field charPos:I
      51: aload_0
      52: getfield      #34                 // Field digits:[I
      55: aload_0
      56: getfield      #28                 // Field r:I
      59: iaload
      60: iastore
      61: aload_0
      62: aload_0
      63: getfield      #26                 // Field q:I
      66: putfield      #23                 // Field i:I
      69: aload_0
      70: getfield      #23                 // Field i:I
      73: ifne          0
      76: return

  public void loop2();
    Code:
       0: aload_0
       1: aload_0
       2: getfield      #23                 // Field i:I
       5: ldc           #25                 // int 52429
       7: imul
       8: bipush        19
      10: iushr
      11: putfield      #26                 // Field q:I
      14: aload_0
      15: aload_0
      16: getfield      #23                 // Field i:I
      19: aload_0
      20: getfield      #26                 // Field q:I
      23: iconst_3
      24: ishl
      25: aload_0
      26: getfield      #26                 // Field q:I
      29: iconst_1
      30: ishl
      31: iadd
      32: isub
      33: putfield      #28                 // Field r:I
      36: aload_0
      37: getfield      #30                 // Field buf:[I
      40: aload_0
      41: dup
      42: getfield      #32                 // Field charPos:I
      45: iconst_1
      46: isub
      47: dup_x1
      48: putfield      #32                 // Field charPos:I
      51: aload_0
      52: getfield      #34                 // Field digits:[I
      55: aload_0
      56: getfield      #28                 // Field r:I
      59: iaload
      60: iastore
      61: aload_0
      62: aload_0
      63: getfield      #26                 // Field q:I
      66: putfield      #23                 // Field i:I
      69: aload_0
      70: getfield      #23                 // Field i:I
      73: ifne          0
      76: return
}