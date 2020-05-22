scala> :javap -c -
  public static final java.lang.Void $anonfun$res0$1(java.lang.String);
    Code:
       0: getstatic     #33                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
       3: aload_0
       4: invokevirtual #37                 // Method scala/Predef$.println:(Ljava/lang/Object;)V
       7: aconst_null
       8: areturn

  public $line3.$read$$iw$$iw$();
    Code:
       0: aload_0
       1: invokespecial #39                 // Method java/lang/Object."<init>":()V
       4: aload_0
       5: putstatic     #41                 // Field MODULE$:L$line3/$read$$iw$$iw$;
       8: aload_0
       9: new           #43                 // class jfunc/Acceptor
      12: dup
      13: invokespecial #44                 // Method jfunc/Acceptor."<init>":()V
      16: invokedynamic #63,  0             // InvokeDynamic #0:apply:()Ljava/util/function/Function;
      21: invokevirtual #67                 // Method jfunc/Acceptor.f:(Ljava/util/function/Function;)V
      24: getstatic     #72                 // Field scala/runtime/BoxedUnit.UNIT:Lscala/runtime/BoxedUnit;
      27: putfield      #74                 // Field res0:Lscala/runtime/BoxedUnit;
      30: return