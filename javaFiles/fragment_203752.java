C:\Users\y7017\Desktop>javac Test.java

C:\Users\y7017\Desktop>javac Test1.java

C:\Users\y7017\Desktop>javap -c Test
Compiled from "Test.java"
public class Test {
    public Test();
        Code:
            0: aload_0
            1: invokespecial #1                  // Method java/lang/Object."<init>":()V
            4: return

    public static void main(java.lang.String[]);
        Code:
            0: iconst_0
            1: istore_1
            2: iload_1
            3: bipush        10
            5: if_icmpge     17
            8: ldc           #2                  // String Tester
            10: astore_2
            11: iinc          1, 1
            14: goto          2
            17: return
}

C:\Users\y7017\Desktop>javap -c Test1
Compiled from "Test1.java"
public class Test1 {
    public Test1();
        Code:
            0: aload_0
            1: invokespecial #1                  // Method java/lang/Object."<init>":()V
            4: return

    public static void main(java.lang.String[]);
        Code:
            0: iconst_0
            1: istore_1
            2: iload_1
            3: bipush        10
            5: if_icmpge     17
            8: ldc           #2                  // String Tester
            10: astore_2
            11: iinc          1, 1
            14: goto          2
            17: return
}