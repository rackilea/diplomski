import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Created by odinsbane on 8/3/15.
 */
public class TransparentOverlay {

    public static void main(String[] args){

        JFrame frame = new JFrame("painting example");

        JPanel panel = new JPanel(){

            @Override
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D)g;
                g2d.setPaint(Color.WHITE);
                g2d.fill(new Rectangle(0, 0, 600, 600));
                g2d.setPaint(Color.BLACK);
                g2d.fillOval(0, 0, 600, 600);

                g2d.setPaint(new Color(0f, 0f, 0.7f, 0.5f));
                g2d.fillRect(400, 400, 200, 200);

                g2d.setPaint(Color.GREEN);
                g2d.setComposite(
                    AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER, 0.8f
                    )
                );

                g2d.fillRect(0,0,200, 200);
                g2d.setPaint(Color.RED);
                g2d.fillRect(400, 0, 200, 200);
            }
        };

        frame.setContentPane(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}