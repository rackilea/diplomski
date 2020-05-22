alf-pro:Learning alf$ javap -p -c ForLoop.class 
  Compiled from "ForLoop.java"
  public class ForLoop {
    private static java.util.logging.Logger logger;

    public ForLoop();
      Code:
         0: aload_0       
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return        

    public static void a(java.lang.Throwable);
      Code:
         0: aload_0       
         1: invokevirtual #2                  // Method java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
         4: astore_1      
         5: iconst_0      
         6: istore_2      
         7: aload_1       
         8: arraylength   
         9: istore_3      
        10: iload_2       
        11: iload_3       
        12: if_icmpge     36
        15: getstatic     #3                  // Field logger:Ljava/util/logging/Logger;
        18: getstatic     #4                  // Field java/util/logging/Level.WARNING:Ljava/util/logging/Level;
        21: aload_1       
        22: iload_2       
        23: aaload        
        24: invokevirtual #5                  // Method java/lang/StackTraceElement.getMethodName:()Ljava/lang/String;
        27: invokevirtual #6                  // Method java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;)V
        30: iinc          2, 1
        33: goto          10
        36: return        

    public static void b(java.lang.Throwable);
      Code:
         0: aload_0       
         1: invokevirtual #2                  // Method java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
         4: astore_1      
         5: iconst_0      
         6: istore_2      
         7: iload_2       
         8: aload_1       
         9: arraylength   
        10: if_icmpge     34
        13: getstatic     #3                  // Field logger:Ljava/util/logging/Logger;
        16: getstatic     #4                  // Field java/util/logging/Level.WARNING:Ljava/util/logging/Level;
        19: aload_1       
        20: iload_2       
        21: aaload        
        22: invokevirtual #5                  // Method java/lang/StackTraceElement.getMethodName:()Ljava/lang/String;
        25: invokevirtual #6                  // Method java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;)V
        28: iinc          2, 1
        31: goto          7
        34: return        

    public static void c(java.lang.Throwable);
      Code:
         0: aload_0       
         1: invokevirtual #2                  // Method java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
         4: astore_1      
         5: aload_1       
         6: arraylength   
         7: istore_2      
         8: iconst_0      
         9: istore_3      
        10: iload_3       
        11: iload_2       
        12: if_icmpge     36
        15: getstatic     #3                  // Field logger:Ljava/util/logging/Logger;
        18: getstatic     #4                  // Field java/util/logging/Level.WARNING:Ljava/util/logging/Level;
        21: aload_1       
        22: iload_3       
        23: aaload        
        24: invokevirtual #5                  // Method java/lang/StackTraceElement.getMethodName:()Ljava/lang/String;
        27: invokevirtual #6                  // Method java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;)V
        30: iinc          3, 1
        33: goto          10
        36: return        

    static {};
      Code:
         0: ldc           #7                  // String log
         2: invokestatic  #8                  // Method java/util/logging/Logger.getLogger:(Ljava/lang/String;)Ljava/util/logging/Logger;
         5: putstatic     #3                  // Field logger:Ljava/util/logging/Logger;
         8: return        
  }