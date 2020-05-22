import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new MyFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MyFrame extends JFrame {

    private JButton imgBtn = new JButton("Open");           

    public MyFrame() {
        setPreferredSize(new Dimension(960, 540));
        setSize(getPreferredSize());

        initBtnListener();
    }    

    // Set listener for imgBtn to respond to a click event.
    public void initBtnListener() {
        imgBtn.addMouseListener(new MyMouseListener(imgBtn, this));
    }

    // A method to receive a parameter from imgBtn's adapter and print it out.
    public void passParamTest(String s) {
        System.out.println(s);
    }
}