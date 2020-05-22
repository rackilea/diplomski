// 0:   new #16; //class scala/runtime/IntRef
// 3:   dup
// 4:   iconst_0
// 5:   invokespecial   #20; //Method scala/runtime/IntRef."<init>":(I)V
// 8:   astore_1
// 9:   getstatic   #25; //Field scala/Predef$.MODULE$:Lscala/Predef$;
// 12:  iconst_0
// 13:  invokevirtual   #29; //Method scala/Predef$.intWrapper:(I)Lscala/runtime/RichInt;
// 16:  ldc #30; //int 10
// 18:  invokevirtual   #36; //Method scala/runtime/RichInt.until:(I)Lscala/collection/immutable/Range$ByOne;
// 21:  new #38; //class test$$anonfun$simpleForLoop$1
// 24:  dup
// 25:  aload_1
// 26:  invokespecial   #41; //Method test$$anonfun$simpleForLoop$1."<init>":(Lscala/runtime/IntRef;)V
// 29:  invokeinterface #47,  2; //InterfaceMethod scala/collection/immutable/Range$ByOne.foreach:(Lscala/Function1;)V
// 34:  return