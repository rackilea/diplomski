public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: new           #2                  // class java/lang/Object
       3: dup           
       4: invokespecial #1                  // Method java/lang/Object."<init>":()V
       7: astore_1      
       8: new           #3                  // class Program$Person
      11: dup           
      12: invokespecial #4                  // Method Program$Person."<init>":()V
      15: astore_2      
      16: new           #3                  // class Program$Person
      19: dup           
      20: invokespecial #4                  // Method Program$Person."<init>":()V
      23: astore_3      
      24: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      27: new           #6                  // class java/lang/StringBuilder
      30: dup           
      31: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      34: ldc           #8                  // String Two runtime-type :  
      36: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      39: aload_2       
      40: invokevirtual #10                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
      43: invokevirtual #11                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      46: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      49: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      52: return        
}