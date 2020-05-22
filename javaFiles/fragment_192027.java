// access flags 0x9
  public static main([Ljava/lang/String;)V throws java/lang/NoSuchMethodException 
    // parameter  args
   L0
    LINENUMBER 11 L0
    INVOKEDYNAMIC accept()Ljava/util/function/Consumer; [
      // handle kind 0x6 : INVOKESTATIC
      java/lang/invoke/LambdaMetafactory.metafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
      // arguments:
      (Ljava/lang/Object;)V, 
      // handle kind 0x6 : INVOKESTATIC
      Main.lambda$main$0(Ljava/lang/Integer;)V, 
      (Ljava/lang/Integer;)V
    ]
    ASTORE 1
   L1
    LINENUMBER 13 L1
    ALOAD 1
    INVOKESTATIC Main.foo (Ljava/util/function/Consumer;)V
   L2
    LINENUMBER 14 L2
    RETURN
   L3
    LOCALVARIABLE args [Ljava/lang/String; L0 L3 0
    LOCALVARIABLE consumer Ljava/util/function/Consumer; L1 L3 1
    // signature Ljava/util/function/Consumer<Ljava/lang/Integer;>;
    // declaration: java.util.function.Consumer<java.lang.Integer>
    MAXSTACK = 1
    MAXLOCALS = 2