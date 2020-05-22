public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String first
       2: astore_1
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: aload_1
      11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      14: ldc           #6                  // String  second
      16: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      22: astore_1
      23: aload_0
      24: arraylength
      25: ifle          48
      28: new           #3                  // class java/lang/StringBuilder
      31: dup
      32: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      35: aload_1
      36: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      39: ldc           #8                  // String  third
      41: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      44: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      47: astore_1
      48: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      51: new           #3                  // class java/lang/StringBuilder
      54: dup
      55: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      58: ldc           #10                 // String s, =
      60: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      63: aload_1
      64: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      67: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      70: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      73: return