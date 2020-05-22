/**
   * Scala 2.8 introduces annotation driven specialization of methods and classes. This avoids
   * boxing of primitives, at the cost of increased code size. It is planned to specialize some classes
   * in the standard library, notable Function1.
   *
   * The type parameter T in echoSpecialized is annotated to instruct the compiler to generated a specialized version
   * for T = Int.
   */
  def callEcho {    
    echo(1)
    echoSpecialized(1)
  }
  // public void callEcho();
  //   Code:
  //    Stack=2, Locals=1, Args_size=1
  //    0:   aload_0
  //    1:   iconst_1
  //    2:   invokestatic    #134; //Method scala/runtime/BoxesRunTime.boxToInteger:(I)Ljava/lang/Integer;
  //    5:   invokevirtual   #138; //Method echo:(Ljava/lang/Object;)Ljava/lang/Object;
  //    8:   pop
  //    9:   aload_0
  //    10:  iconst_1
  //    11:  invokevirtual   #142; //Method echoSpecialized$mIc$sp:(I)I
  //    14:  pop
  //    15:  return


  def echo[T](t: T): T = t
  def echoSpecialized[@specialized("Int") T](t: T): T = t
}