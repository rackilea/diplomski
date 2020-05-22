/**
   * Scala allows 'Structural Types', which let you have a compiler-checked version
   * of 'Duck Typing'. In Scala 2.7, the invocation of .size was done with reflection.
   * In 2.8, the Method object is looked up on first invocation, and cached for later
   * invocations..
   */
  def duckType {
    val al = new java.util.ArrayList[AnyRef]
    (al: { def size(): Int }).size()
  }
  // [snip]
  // 13:  invokevirtual #106; //Method java/lang/Object.getClass:()Ljava/lang/Class;
  // 16:  invokestatic  #108; //Method reflMethod$Method1:(Ljava/lang/Class;)Ljava/lang/reflect/Method;
  // 19:  aload_2
  // 20:  iconst_0
  // 21:  anewarray #102; //class java/lang/Object
  // 24:  invokevirtual #114; //Method java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
  // 27:  astore_3
  // 28:  aload_3
  // 29:  checkcast #116; //class java/lang/Integer