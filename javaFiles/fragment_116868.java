import javax.swing.*;
public class Hello_World {
    public static class HelloWorld extends JFrame
    {  

    }
    public static void main(String[] args) {
        JFrame frame = new HelloWorld();
        frame.setSize( 300, 200 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "Hello world" );
        frame.setVisible( true );
    }
}