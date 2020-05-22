class Clazz$1 extends Clazz {
  Clazz$1(java.lang.Integer);
    Code:
       0: aload_0       
       1: aload_1       
       2: putfield      #10                 // Field val$i:Ljava/lang/Integer;
       5: aload_0       
       6: invokespecial #12                 // Method Clazz."<init>":()V
       9: return        

  void foo();
    Code:
       0: getstatic     #20                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: aload_0       
       4: getfield      #10                 // Field val$i:Ljava/lang/Integer;
       7: invokevirtual #26                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      10: return        
}