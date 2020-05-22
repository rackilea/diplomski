public class java8.tests.General {
  public java8.tests.General();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class javax/swing/JFileChooser
       3: dup
       4: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
       7: astore_1
       8: aload_1
       9: new           #4                  // class java/io/File
      12: dup
      13: ldc           #5                  // String .
      15: invokespecial #6                  // Method java/io/File."<init>":(Ljava/lang/String;)V
      18: invokevirtual #7                  // Method javax/swing/JFileChooser.setCurrentDirectory:(Ljava/io/File;)V
      21: return
}