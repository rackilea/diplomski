public static void function_2();
Code:
   0: ldc           #39                 // String 1
   2: putstatic     #16                 // Field j:Ljava/lang/String;
   5: return        


public static void function_3();
Code:
   0: new           #42                 // class java/lang/StringBuilder
   3: dup           
   4: invokespecial #44                 // Method java/lang/StringBuilder."<init>":()V
   7: invokestatic  #28                 // Method getOne:()I
  10: invokevirtual #45                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  13: invokevirtual #49                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
  16: putstatic     #16                 // Field j:Ljava/lang/String;
  19: return