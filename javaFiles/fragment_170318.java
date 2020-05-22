Compiled from "LocalInnerClassAppl.java"
class pkg.LocalInnerClassAppl$1Iter extends java.lang.Object implements java.util.Iterator{
private int pos;

private final java.lang.Object[] val$objs;

pkg.LocalInnerClassAppl$1Iter(java.lang.Object[]);
  Code:
   0:   aload_0
   1:   aload_1
   2:   putfield    #14; //Field val$objs:[Ljava/lang/Object;
   5:   aload_0
   6:   invokespecial   #16; //Method java/lang/Object."<init>":()V
   9:   aload_0
   10:  iconst_0
   11:  putfield    #19; //Field pos:I
   14:  return

public boolean hasNext();
  Code:
   0:   aload_0
   1:   getfield    #19; //Field pos:I
   4:   aload_0
   5:   getfield    #14; //Field val$objs:[Ljava/lang/Object;
   8:   arraylength
   9:   if_icmpge   14
   12:  iconst_1
   13:  ireturn
   14:  iconst_0
   15:  ireturn

public java.lang.Object next()   throws java.util.NoSuchElementException;
  Code:
   0:   aload_0
   1:   getfield    #19; //Field pos:I
   4:   aload_0
   5:   getfield    #14; //Field val$objs:[Ljava/lang/Object;
   8:   arraylength
   9:   if_icmplt   20
   12:  new #31; //class java/util/NoSuchElementException
   15:  dup
   16:  invokespecial   #33; //Method java/util/NoSuchElementException."<init>":()V
   19:  athrow
   20:  aload_0
   21:  getfield    #14; //Field val$objs:[Ljava/lang/Object;
   24:  aload_0
   25:  dup
   26:  getfield    #19; //Field pos:I
   29:  dup_x1
   30:  iconst_1
   31:  iadd
   32:  putfield    #19; //Field pos:I
   35:  aaload
   36:  areturn

public void remove();
  Code:
   0:   new #35; //class java/lang/UnsupportedOperationException
   3:   dup
   4:   invokespecial   #37; //Method java/lang/UnsupportedOperationException."<init>":()V
   7:   athrow

}