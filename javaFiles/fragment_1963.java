public class Test{

private JTextArea textArea;


public static void someMethod(){
    //textArea = new JTextArea(); you can't do this
     //you need an instance
     Test test = new Test();
     test.textArea = new JTextArea(10,10);
     test.textArea.setText("Hello world");

}
}