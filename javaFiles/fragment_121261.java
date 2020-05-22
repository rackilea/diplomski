object test {
  /**
   * From the perspective of the Scala Language, there isn't a distinction between
   * objects, primitives, and arrays. They are all unified under a single type system,
   * with Any as the top type.
   *
   * Array access, from a language perspective, looks like a.apply(0), or a.update(0, 1)
   * But this is compiled to efficient bytecode without method calls. 
   */
  def accessPrimitiveArray {
    val a = Array.fill[Int](2, 2)(1)
    a(0)(1) = a(1)(0)        
  }
  // 0: getstatic #62; //Field scala/Array$.MODULE$:Lscala/Array$;
  // 3: iconst_2
  // 4: iconst_2
  // 5: new #64; //class test$$anonfun$1
  // 8: dup
  // 9: invokespecial #65; //Method test$$anonfun$1."<init>":()V
  // 12:  getstatic #70; //Field scala/reflect/Manifest$.MODULE$:Lscala/reflect/Manifest$;
  // 15:  invokevirtual #74; //Method scala/reflect/Manifest$.Int:()Lscala/reflect/AnyValManifest;
  // 18:  invokevirtual #78; //Method scala/Array$.fill:(IILscala/Function0;Lscala/reflect/ClassManifest;)[Ljava/lang/Object;
  // 21:  checkcast #80; //class "[[I"
  // 24:  astore_1
  // 25:  aload_1
  // 26:  iconst_0
  // 27:  aaload
  // 28:  iconst_1
  // 29:  aload_1
  // 30:  iconst_1
  // 31:  aaload
  // 32:  iconst_0
  // 33:  iaload
  // 34:  iastore
  // 35:  return