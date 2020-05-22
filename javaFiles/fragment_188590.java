public static void main(java.lang.String[]);
    Code:
       0: new           #16                 // class java/lang/RuntimeException
       3: dup           
       4: ldc           #18                 // String My Exception
       6: invokespecial #20                 // Method java/lang/RuntimeException."<init>":(Ljava/lang/String;)V
       9: astore_1      
      10: aconst_null   
      11: astore_2      
      12: aconst_null   
      13: astore_3      
      14: new           #23                 // class TestDoubleThrow$1TestA
      17: dup           
      18: aload_1       
      19: invokespecial #25                 // Method TestDoubleThrow$1TestA."<init>":(Ljava/lang/RuntimeException;)V
      22: astore        4
      24: aload_1       
      25: athrow        
      26: astore_2      
      27: aload         4
      29: ifnull        37
      32: aload         4
      34: invokevirtual #28                 // Method TestDoubleThrow$1TestA.close:()V
      37: aload_2       
      38: athrow        
      39: astore_3      
      40: aload_2       
      41: ifnonnull     49
      44: aload_3       
      45: astore_2      
      46: goto          59
      49: aload_2       
      50: aload_3       
      51: if_acmpeq     59
      54: aload_2       
      55: aload_3       
      56: invokevirtual #31                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
      59: aload_2       
      60: athrow        
    Exception table:
       from    to  target type
          24    26    26   any
          14    39    39   any