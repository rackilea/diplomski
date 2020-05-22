import javax.swing.*;
import java.awt.*;

public class td {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Train Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new TrainCanvas());
        frame.setVisible(true);
    }

}

class TrainCanvas extends JComponent {

    private int lastX = 0;

    public TrainCanvas() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
while(true)
{
String str1 = JOptionPane.showInputDialog("france has how many varieties of cheese ? a: 100 b: 200 c: 250");
if(str1.equals("c"))
{       

                    repaint();
                    try {Thread.sleep(100);} catch (Exception ex) {}  
String str2 = JOptionPane.showInputDialog("where did noodles originate ? a: India b: Italy c: China");
if(str2.equals("b"))
{       

                    repaint();
                    try {Thread.sleep(100);} catch (Exception ex) {}     
String str3 = JOptionPane.showInputDialog("which place is famous for good chocolate ? a: switzerland b: Germany c: China");
if(str3.equals("a"))
{       

                    repaint();
                    try {Thread.sleep(100);} catch (Exception ex) {}   
String str4 = JOptionPane.showInputDialog("what is the staple food of India ? a: rice b: bread c: roti");
if(str4.equals("a"))
{       

                    repaint();
                    try {Thread.sleep(100);} catch (Exception ex) {}   
String str5 = JOptionPane.showInputDialog("where did ice cream originate ? a: greenland b: china c: korea");
if(str5.equals("b"))
{       

                    repaint();
                    try {Thread.sleep(100);} catch (Exception ex) {}
JOptionPane.showMessageDialog( null, "GOOD JOB!!!   LEVEL COMPLETE ", "answer", JOptionPane.INFORMATION_MESSAGE); 
break;
}
else
{
JOptionPane.showMessageDialog( null, "GAME OVER  (restarting...) ", "answer", JOptionPane.INFORMATION_MESSAGE);

} 
} 
else
{
JOptionPane.showMessageDialog( null, "GAME OVER  (restarting...) ", "answer", JOptionPane.INFORMATION_MESSAGE);
}
}
else
{
JOptionPane.showMessageDialog( null, "GAME OVER  (restarting...) ", "answer", JOptionPane.INFORMATION_MESSAGE);
}
}
else
{
JOptionPane.showMessageDialog( null, "GAME OVER  (restarting...)", "answer", JOptionPane.INFORMATION_MESSAGE);
}
}
else
{
JOptionPane.showMessageDialog( null, "GAME OVER  (restarting...)", "answer", JOptionPane.INFORMATION_MESSAGE);
}


            }
}
        });

 animationThread.start();

 }

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        int trainW = 100;
        int trainH = 10;
        int trainSpeed = 30;

        int x = lastX + trainSpeed;

        gg.setColor(Color.BLACK);
        gg.fillRect(x, h/2 + trainH, trainW, trainH);

      lastX = x;
    }

}