public class Foo extends java.lang.Object{

protected javax.swing.JTextField nameTextField;

public Foo();
  Code:
   0:   aload_0
   1:   invokespecial   #10; //Method java/lang/Object."<init>":()V
   4:   return

public void foo(User);
  Code:
   0:   new     #18; //class Foo$1
   3:   dup
   4:   aload_0
   5:   aload_1
   6:   invokespecial   #20; //Method Foo$1."<init>":(LFoo;LUser;)V
   9:   invokestatic    #23; //Method java/awt/EventQueue.invokeLater:        (Ljava/lang/Runnable;)V
   12:  return

}