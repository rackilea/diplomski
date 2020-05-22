$ javap -c Temp.class
 Compiled from "Temp.java"
  class Temp {
    Temp();                                                                                                                             
      Code:
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return

    public static void main(java.lang.String[]);                                                                                        
      Code:
         0: bipush        27
         2: istore_1
         3: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;                                       
         6: iload_1
         7: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        10: return
  }