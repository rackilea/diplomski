Compiled from "A.java"
class A extends java.lang.Object{
A();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

void testSwitch(A$N);
  Code:
   0:   getstatic   #2; //Field A$1.$SwitchMap$A$N:[I
   3:   aload_1
   4:   invokevirtual   #3; //Method A$N.ordinal:()I
   7:   iaload
   8:   tableswitch{ //1 to 3
        1: 36;
        2: 43;
        3: 50;
        default: 54 }
   36:  aload_0
   37:  invokevirtual   #4; //Method x:()V
   40:  goto    54
   43:  aload_0
   44:  invokevirtual   #4; //Method x:()V
   47:  goto    54
   50:  aload_0
   51:  invokevirtual   #4; //Method x:()V
   54:  return

void testIf(java.lang.Enum);
  Code:
   0:   aload_1
   1:   getstatic   #5; //Field A$N.ONE:LA$N;
   4:   if_acmpne   14
   7:   aload_0
   8:   invokevirtual   #4; //Method x:()V
   11:  goto    39
   14:  aload_1
   15:  getstatic   #6; //Field A$N.TWO:LA$N;
   18:  if_acmpne   28
   21:  aload_0
   22:  invokevirtual   #4; //Method x:()V
   25:  goto    39
   28:  aload_1
   29:  getstatic   #7; //Field A$N.THREE:LA$N;
   32:  if_acmpne   39
   35:  aload_0
   36:  invokevirtual   #4; //Method x:()V
   39:  return

void x();
  Code:
   0:   return

}