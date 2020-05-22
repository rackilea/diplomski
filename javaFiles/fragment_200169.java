public class FrameClass extends JFrame {
        JLabel label1;// package access
        MyDialog dialog;

        //constructor *** Netbeans may have an init() method ***
        public FrameClass(){
        label1=new JLabel("Hello!");
        ...
        }

        ...
    }

public class MyDialog{
    public void changeLabel(){
        FrameClass.label1.setText("Good Bye!");
    }
}