public static void plusOperator();
Code:

  16: iload         4
  18: ldc           #10                 // int 100000000
  20: if_icmpge     53
  23: new           #11                 // class java/lang/StringBuilder
  26: dup           
  27: invokespecial #12                 // Method java/lang/StringBuilder."<init>":()V
  30: aload_0       
  31: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  34: aload_1       
  35: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  38: aload_2       
  39: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  42: invokevirtual #14                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
  45: astore        5
  47: iinc          4, 1
  50: goto          16


public static void stringBuilder();
Code:

  16: iload         4
  18: ldc           #10                 // int 100000000
  20: if_icmpge     50
  23: new           #11                 // class java/lang/StringBuilder
  26: dup           
  27: invokespecial #12                 // Method java/lang/StringBuilder."<init>":()V
  30: aload_0       
  31: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  34: aload_1       
  35: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  38: aload_2       
  39: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  42: astore        5
  44: iinc          4, 1
  47: goto          16