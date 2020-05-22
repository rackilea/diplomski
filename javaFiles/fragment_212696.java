$ javap -c OuterClass\$InnerClass
Compiled from "OuterClass.java"
class OuterClass$InnerClass extends java.lang.Object{
static int access$002(int);
  Code:
   0: iload_0
   1: dup
   2: putstatic #1; //Field foo:I
   5: ireturn

static int access$000();
  Code:
   0: getstatic #1; //Field foo:I
   3: ireturn

}