public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/lang/RuntimeException
       3: dup           
       4: ldc           #3                  // String My Exception
       6: invokespecial #4                  // Method java/lang/RuntimeException."<init>":(Ljava/lang/String;)V
       9: astore_1      
      10: new           #5                  // class TestDoubleThrow$1TestA
      13: dup           
      14: aload_1       
      15: invokespecial #6                  // Method TestDoubleThrow$1TestA."<init>":(Ljava/lang/RuntimeException;)V
      18: astore_2      
      19: aconst_null   
      20: astore_3      
      21: aload_1       
      22: athrow        
      23: astore        4
      25: aload         4
      27: astore_3      
      28: aload         4
      30: athrow        
      31: astore        5
      33: aload_2       
      34: ifnull        63
      37: aload_3       
      38: ifnull        59
      41: aload_2       
      42: invokevirtual #8                  // Method TestDoubleThrow$1TestA.close:()V
      45: goto          63
      48: astore        6
      50: aload_3       
      51: aload         6
      53: invokevirtual #9                  // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
      56: goto          63
      59: aload_2       
      60: invokevirtual #8                  // Method TestDoubleThrow$1TestA.close:()V
      63: aload         5
      65: athrow        
    Exception table:
       from    to  target type
          21    23    23   Class java/lang/Throwable
          41    45    48   Class java/lang/Throwable
          21    33    31   any