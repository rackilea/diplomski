class Foo$1 extends java.lang.Object implements java.lang.Runnable{
final Foo this$0;

private final User val$user;

Foo$1(Foo, User);
  Code:
   0:   aload_0
   1:   aload_1
   2:   putfield    #14; //Field this$0:LFoo;
   5:   aload_0
   6:   aload_2
   7:   putfield    #16; //Field val$user:LUser;
   10:  aload_0
   11:  invokespecial   #18; //Method java/lang/Object."<init>":()V
   14:  return

public void run();
  Code:
   0:   aload_0
   1:   getfield    #14; //Field this$0:LFoo;
   4:   getfield    #26; //Field Foo.nameTextField:Ljavax/swing/JTextField;
   7:   aload_0
   8:   getfield    #16; //Field val$user:LUser;
   11:  invokeinterface #32,  1; //InterfaceMethod User.getName:()Ljava/lang/String;
   16:  invokevirtual   #38; //Method javax/swing/JTextField.setText:(Ljava/lang/String;)V
   19:  return

}