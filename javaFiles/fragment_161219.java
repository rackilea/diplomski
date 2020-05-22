import javax.swing.JFrame;


public class CustomJFrame extends JFrame{
    public CustomJFrame(){
        //set its size in px.
        setSize(200,200);
        //center it on screen.
        setLocationRelativeTo(null);
        //give it a title.
        setTitle("My JFrame");
        //set the close operation.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make it visible.
        setVisible(true);
    }
}