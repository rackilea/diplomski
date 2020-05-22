scala> :javap -v MyOrdered
Compiled from "<console>"
public abstract class MyOrdered extends java.lang.Object implements scala.math.Ordered,scala.ScalaObject

...
** I'm skipping lots of things here: $less, $lessEq, ... **
...

public boolean $greater(java.lang.Object);
  Code:
   Stack=2, Locals=2, Args_size=2
   0:   aload_0
   1:   aload_1
   2:   invokestatic    #19; //Method scala/math/Ordered$class.$greater:(Lscala/math/Ordered;Ljava/lang/Object;)Z
   5:   ireturn
  LineNumberTable: 
   line 7: 0

...

public abstract int id();

public int compare(MyOrdered);
  Code:
   Stack=2, Locals=2, Args_size=2
   0:   aload_1
   1:   ifnonnull   8
   4:   iconst_1
   5:   goto    17
   8:   aload_0
   9:   invokevirtual   #38; //Method id:()I
   12:  aload_1
   13:  invokevirtual   #38; //Method id:()I
   16:  isub
   17:  ireturn
  LineNumberTable: 
   line 10: 0

 ...