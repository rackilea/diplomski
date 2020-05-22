import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
    public class LayoutExample {
        public static void main (String[] args) {
            JFrame frame = new JFrame("Frame with BorderLayout");
            frame.setLayout(new BorderLayout());
            JPanel flow = new JPanel();
            JLabel label = new JLabel("This is a flowlayout.");
            flow.setBorder(new LineBorder(Color.BLACK));
            flow.setLayout(new FlowLayout());
            flow.add(label);

            frame.add(flow, BorderLayout.NORTH);
            frame.setSize(300,300);
            frame.setVisible(true);
       } 
    }