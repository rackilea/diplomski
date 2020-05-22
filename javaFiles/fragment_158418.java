14:09:58 :: javap $ javap -c Test
Compiled from "Test.java"
class Test extends java.lang.Object{
java.lang.String a;

java.lang.StringBuilder buffer;

Test();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   aload_0
   5:   ldc #2; //String abc
   7:   putfield    #3; //Field a:Ljava/lang/String;
   10:  aload_0
   11:  new #4; //class java/lang/StringBuilder
   14:  dup
   15:  invokespecial   #5; //Method java/lang/StringBuilder."<init>":()V
   18:  putfield    #6; //Field buffer:Ljava/lang/StringBuilder;
   21:  return

public void normal();
  Code:
   0:   aload_0
   1:   getfield    #6; //Field buffer:Ljava/lang/StringBuilder;
   4:   ldc #2; //String abc
   6:   invokevirtual   #7; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   9:   pop
   10:  aload_0
   11:  getfield    #6; //Field buffer:Ljava/lang/StringBuilder;
   14:  ldc #2; //String abc
   16:  invokevirtual   #7; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   19:  pop
   20:  return

public void clever();
  Code:
   0:   aload_0
   1:   getfield    #6; //Field buffer:Ljava/lang/StringBuilder;
   4:   aload_0
   5:   getfield    #3; //Field a:Ljava/lang/String;
   8:   invokevirtual   #7; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   11:  pop
   12:  aload_0
   13:  getfield    #6; //Field buffer:Ljava/lang/StringBuilder;
   16:  aload_0
   17:  getfield    #3; //Field a:Ljava/lang/String;
   20:  invokevirtual   #7; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   23:  pop
   24:  return

}