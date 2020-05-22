public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #16                 // Method common/Singleton.getInstance:()Lcommon/Singleton;
       3: astore_1
       4: aconst_null
       5: astore_1
       6: getstatic     #22                 // Field java/lang/System.out:Ljava/io/PrintStream;
       9: aload_1
      10: invokevirtual #28                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      13: invokestatic  #34                 // Method Lcommon/Singleton.getDemo:()V
      16: return
}