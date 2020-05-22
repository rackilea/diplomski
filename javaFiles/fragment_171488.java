import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class AlignmentTest extends JPanel
{
    public AlignmentTest(char label, int style)
    {
        JLabel l = new JLabel(Character.toString(label));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        setBackground(Color.WHITE);
//        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setLayout(new RelativeLayout(RelativeLayout.Y_AXIS));
        setPreferredSize(new Dimension(300,50));
//        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue(), new Float(1));
        add(l);
            l.setFont(l.getFont().deriveFont(style));
            l.setAlignmentX(CENTER_ALIGNMENT);
            l.setHorizontalAlignment(JLabel.CENTER);
//        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue(), new Float(1));
    }
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Alignment Test");
        JScrollPane scroller = new JScrollPane();
            JPanel panel = new JPanel(new GridLayout(1,0,5,5));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1,0,5,5));
        f.add(new AlignmentTest('a',Font.PLAIN));
        f.add(new AlignmentTest('a',Font.BOLD));
        f.add(new AlignmentTest('a',Font.ITALIC));
        f.pack();
        f.setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
    }
}