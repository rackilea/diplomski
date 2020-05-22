public class Test{

Test2 test = new Test2();
JFrame frame = new JFrame();

Test(){
...
frame.setLayout(new BorderLayout());
frame.add(test, BorderLayout.CENTER);
...
}

//main
...
}

//public class Test2{
public class Test2 extends JPanel {

//JPanel test2 = new JPanel();

Test2(){
...
}