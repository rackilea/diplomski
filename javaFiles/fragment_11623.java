public main(java.lang.String[] arg0) { //([Ljava/lang/String;)V
     <localVar:index=3 , name=mySuperString , desc=Ljava/lang/String;, sig=null, start=L1, end=L2>
     <localVar:index=2 , name=age , desc=I, sig=null, start=L3, end=L2>
     <localVar:index=0 , name=this , desc=Lorg/guenhter/springboot/kt/RandomReceivingController;, sig=null, start=L4, end=L2>
     <localVar:index=1 , name=args , desc=[Ljava/lang/String;, sig=null, start=L4, end=L2>

     L4 {
         aload1
         ldc "args" (java.lang.String)
         invokestatic kotlin/jvm/internal/Intrinsics checkParameterIsNotNull((Ljava/lang/Object;Ljava/lang/String;)V);
     }
     L5 {
         bipush 24
         istore2
     }
     L3 {
         new java/lang/StringBuilder
         dup
         invokespecial java/lang/StringBuilder <init>(()V);
         ldc "Dato is " (java.lang.String)
         invokevirtual java/lang/StringBuilder append((Ljava/lang/String;)Ljava/lang/StringBuilder;);
         iload2
         invokevirtual java/lang/StringBuilder append((I)Ljava/lang/StringBuilder;);
         ldc " years old!" (java.lang.String)
         invokevirtual java/lang/StringBuilder append((Ljava/lang/String;)Ljava/lang/StringBuilder;);
         invokevirtual java/lang/StringBuilder toString(()Ljava/lang/String;);
         astore3
     }
     L1 {
         getstatic java/lang/System.out:java.io.PrintStream
         aload3
         invokevirtual java/io/PrintStream println((Ljava/lang/Object;)V);
     }
     L6 {
         return
     }
     L2 {
     }
 }