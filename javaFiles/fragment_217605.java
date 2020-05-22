javap -c test
Compiled from "test.java"
public class test extends java.lang.Object{
public test();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[])   throws java.lang.Exception;
  Code:
   0:   ldc #2; //String CR_ABC_DEF_GHI
   2:   astore_1
   3:   ldc #3; //String TYPE=Eligibility Only|CLIENT_ID=62|EMPLOYER_ID=0|LOCATION_ID=0|PLAN_ID=all|FREQUENCY=52|FILE=null|FILETYPE=C|PROCESSTOLAUNCH=10|PROCESSTOLAUNCHSTATUS=100|SCHEDULE_ID=29837d692f4c43e786f1097fab7c360c
   5:   astore_2
   6:   ldc #4; //String \|
   8:   astore_3
   9:   ldc #5; //String FILE_NAME_TEMPLATE
   11:  astore  4
   13:  ldc #6; //String FILE
   15:  astore  5
   17:  new #7; //class java/lang/StringBuilder
   20:  dup
   21:  invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   24:  aload_3
   25:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   28:  aload   4
   30:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   33:  ldc #10; //String =
   35:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   38:  ldc #11; //String [^
   40:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   43:  aload_3
   44:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   47:  ldc #12; //String ]*
   49:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   52:  aload_3
   53:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   56:  invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   59:  astore  6
   61:  new #7; //class java/lang/StringBuilder
   64:  dup
   65:  invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   68:  aload_3
   69:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   72:  aload   5
   74:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   77:  ldc #10; //String =
   79:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   82:  ldc #11; //String [^
   84:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   87:  aload_3
   88:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   91:  ldc #12; //String ]*
   93:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   96:  aload_3
   97:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   100: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   103: astore  7
   105: new #7; //class java/lang/StringBuilder
   108: dup
   109: invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   112: aload_3
   113: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   116: aload   4
   118: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   121: ldc #10; //String =
   123: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   126: aload_1
   127: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   130: aload_3
   131: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   134: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   137: astore  8
   139: aload_2
   140: aload   6
   142: aload   8
   144: invokevirtual   #14; //Method java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   147: aload   7
   149: aload   8
   151: invokevirtual   #14; //Method java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   154: astore  9
   156: getstatic   #15; //Field java/lang/System.out:Ljava/io/PrintStream;
   159: new #7; //class java/lang/StringBuilder
   162: dup
   163: invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   166: ldc #16; //String before = 
   168: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   171: aload_2
   172: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   175: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   178: invokevirtual   #17; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   181: getstatic   #15; //Field java/lang/System.out:Ljava/io/PrintStream;
   184: new #7; //class java/lang/StringBuilder
   187: dup
   188: invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   191: ldc #18; //String pattern1 = 
   193: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   196: aload   6
   198: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   201: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   204: invokevirtual   #17; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   207: getstatic   #15; //Field java/lang/System.out:Ljava/io/PrintStream;
   210: new #7; //class java/lang/StringBuilder
   213: dup
   214: invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   217: ldc #19; //String pattern2 = 
   219: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   222: aload   7
   224: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   227: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   230: invokevirtual   #17; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   233: getstatic   #15; //Field java/lang/System.out:Ljava/io/PrintStream;
   236: new #7; //class java/lang/StringBuilder
   239: dup
   240: invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   243: ldc #20; //String replace = 
   245: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   248: aload   8
   250: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   253: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   256: invokevirtual   #17; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   259: getstatic   #15; //Field java/lang/System.out:Ljava/io/PrintStream;
   262: new #7; //class java/lang/StringBuilder
   265: dup
   266: invokespecial   #8; //Method java/lang/StringBuilder."<init>":()V
   269: ldc #21; //String after = 
   271: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   274: aload   9
   276: invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   279: invokevirtual   #13; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   282: invokevirtual   #17; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   285: return

}