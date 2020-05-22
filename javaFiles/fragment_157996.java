public class MyClass{
    //...
}

public class MyFrame extends JFrame{
    private MyClass obj;

    public MyFrame(MyClass obj){
        this.obj = obj;
        //...
    }

    //...

    public void paintComponent(Graphics g){
        // Paint obj in here
    }

}