/**
   * Rather than dynamically adding methods to a meta-class, Scala
   * allows values to be implicity converted. The conversion is
   * fixed at compilation time. At runtime, there is an overhead to
   * instantiate RichAny before foo is called. HotSpot may be able to
   * eliminate this overhead, and future versions of Scala may do so
   * in the compiler.
   */
  def callPimpedMethod {    
    class RichAny(a: Any) {
      def foo = 0
    }
    implicit def ToRichAny(a: Any) = new RichAny(a)
    new {}.foo
  }
  // 0: aload_0
  //   1: new #85; //class test$$anon$1
  //   4: dup
  //   5: invokespecial #86; //Method test$$anon$1."<init>":()V
  //   8: invokespecial #90; //Method ToRichAny$1:(Ljava/lang/Object;)Ltest$RichAny$1;
  //   11:  invokevirtual #96; //Method test$RichAny$1.foo:()I
  //   14:  pop
  //   15:  return