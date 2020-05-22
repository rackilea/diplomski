Compiled from "TestNested.java"
  public class a.TestNested {
    public a.TestNested();
      Code:
         0: aload_0       
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return        

    public static void main(java.lang.String[]);
      Code:
         0: ldc_w         #2                  // class a/TestNested$A
         3: astore_1      
         4: aload_1       
         5: invokevirtual #3                  // Method java/lang/Class.getDeclaredConstructors:()[Ljava/lang/reflect/Constructor;
         8: astore_2      
         9: aload_2       
        10: arraylength   
        11: istore_3      
        12: iconst_0      
        13: istore        4
        15: iload         4
        17: iload_3       
        18: if_icmpge     41
        21: aload_2       
        22: iload         4
        24: aaload        
        25: astore        5
        27: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
        30: aload         5
        32: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
        35: iinc          4, 1
        38: goto          15
        41: new           #2                  // class a/TestNested$A
        44: dup           
        45: new           #6                  // class a/TestNested
        48: dup           
        49: invokespecial #7                  // Method "<init>":()V
        52: dup           
        53: invokevirtual #8                  // Method java/lang/Object.getClass:()Ljava/lang/Class;
        56: pop           
        57: bipush        123
        59: aconst_null   
        60: invokespecial #9                  // Method a/TestNested$A."<init>":(La/TestNested;ILa/TestNested$1;)V
        63: astore_2      
        64: return        
  }