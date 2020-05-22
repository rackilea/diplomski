Compiled from "Foo.java"
public class Foo extends java.lang.Object{
static final boolean $assertionsDisabled;

Foo(java.lang.String);
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   getstatic   #2; //Field $assertionsDisabled:Z
   7:   ifne    22
   10:  aload_1
   11:  ifnonnull   22
   14:  new #3; //class java/lang/AssertionError
   17:  dup
   18:  invokespecial   #4; //Method java/lang/AssertionError."<init>":()V
   21:  athrow
   22:  return

static {};
  Code:
   0:   ldc_w   #5; //class Foo
   3:   invokevirtual   #6; //Method java/lang/Class.desiredAssertionStatus:()Z
   6:   ifne    13
   9:   iconst_1
   10:  goto    14
   13:  iconst_0
   14:  putstatic   #2; //Field $assertionsDisabled:Z
   17:  return