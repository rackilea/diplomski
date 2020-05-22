import java.awt.*;
import javax.swing.*;

public class WinLockDetect {

public static void main(String[] args) {

    try {
        new WinLockDetect().demo();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@SuppressWarnings("serial")
void demo() throws Exception {

    final JTextArea detectMsgs =new JTextArea();
    final JFrame window = new JFrame() {{
        getContentPane().add(detectMsgs);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }};
    EventQueue.invokeLater(new Runnable() {
        public void run() { 
            window.setVisible(true); 
        };
    });
    Win32EventDetector winSessionDetect = new Win32EventDetector();
    winSessionDetect.setMsgLogger(detectMsgs);
    new Thread(winSessionDetect).start();
    Thread.sleep(500L);
    window.setState(java.awt.Frame.ICONIFIED);
}

}