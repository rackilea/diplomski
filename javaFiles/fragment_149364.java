import java.awt.*;

class MyObj extends JPanel {
    public MyComponent(ImageIcon pic, String label1, String label2) {
        setLayout(new BorderLayout());
        add(new JLabel(label1), BorderLayout.NORTH);
        add(new JLabel(pic), BorderLayout.CENTER);
        add(new JLabel(label2), BorderLayout.SOUTH);
    }
}

public class FrameTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Demo");
        jf.add(new MyObj(new ImageIcon("duke.jpg"), "Label 1", "Label 2"));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}