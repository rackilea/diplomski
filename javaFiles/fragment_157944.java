import javax.swing.*;

public class jframe1 {

    // It's String[] args
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("clikity");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}