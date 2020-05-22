scala> :javap -v scala.math.Ordered$class
Compiled from "Ordered.scala"
public abstract class scala.math.Ordered$class extends java.lang.Object
...
public static boolean $greater(scala.math.Ordered, java.lang.Object);
  Code:
   Stack=2, Locals=2, Args_size=2
   0:   aload_0
   1:   aload_1
   2:   invokeinterface #12,  2; //InterfaceMethod scala/math/Ordered.compare:(Ljava/lang/Object;)I
   7:   iconst_0
   8:   if_icmple   15
   11:  iconst_1
   12:  goto    16
   15:  iconst_0
   16:  ireturn
  LineNumberTable: 
   line 46: 0
...