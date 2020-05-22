public class MyFrameView {

private JFrame frame;

     MyFrameView(){
       frame = new JFrame();
       frame.addKeyListener(new MyKeyListener());
     }

}

public class MyKeyListener implements KeyListener{

}