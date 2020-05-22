import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {

    JButton but1 = new JButton("MakeMoney");
    JButton button1 = new JButton("Current money");
    int money = 0;
    double currentMoney;
    String moneyString = "";

    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/TPC/workspace/ProjectMoney/Resources/backgroundForApp.png")))));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.setLayout(new BorderLayout());

        button1.setContentAreaFilled(false);

        ListenForButton lforButton = new ListenForButton();
        but1.addActionListener(lforButton);

        JPanel thePanel = new JPanel();
        thePanel.add(button1);
        thePanel.add(but1);

        this.setSize(1042, 617);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Project Money");
        this.add(thePanel, BorderLayout.NORTH);
        this.add(new DrawStuff(), BorderLayout.CENTER);
        this.setResizable(true);
        this.setVisible(true);

        Sound sound1 = new Sound();
        String sound = "file:C:/Users/TPC/Downloads/sound.wav";
        sound1.playMusic(sound);

    }

    private class ListenForButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == but1) {
                money += 10;
                moneyString = Integer.toString(money);
                button1.setText("$" + moneyString);
            }
        }
    }

    private class DrawStuff extends JComponent {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graph2 = (Graphics2D) g;
            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape drawLine = new Line2D.Float(20, 90, 55, 250);

            Shape drawArc2D = new Arc2D.Double(5, 150, 100, 100, 45, 180, Arc2D.OPEN);

            Shape drawArc2D2 = new Arc2D.Double(5, 200, 100, 100, 45, 45, Arc2D.CHORD);

            Shape drawArc2D3 = new Arc2D.Double(5, 250, 100, 100, 45, 45, Arc2D.PIE);

            Shape drawEllipse = new Ellipse2D.Float(10, 10, 100, 100);

            Shape drawRoundRec = new RoundRectangle2D.Double(25, 25, 50, 50, 45, 45);
            CubicCurve2D cubicCurve = new CubicCurve2D.Double();

            cubicCurve.setCurve(110, 50, 300,
                    200, 200, 200, 90, 263);

            Shape drawRect = new Rectangle2D.Float(300, 300, 150, 100);

            Shape drawQuadCurve = new QuadCurve2D.Float(300, 100, 400, 200, 150, 300);

            Shape drawTransRect = new Rectangle2D.Double(300, 300, 75, 50);

            graph2.setPaint(Color.BLACK);

            graph2.draw(drawLine);

            graph2.draw(drawArc2D);

            graph2.draw(drawArc2D2);

            graph2.draw(drawArc2D3);

            graph2.draw(drawEllipse);

            graph2.setColor(Color.GREEN);

            graph2.fill(drawRoundRec);
            graph2.fill(drawRect);
            graph2.setPaint(Color.BLACK);
            graph2.draw(cubicCurve);
            graph2.draw(drawRect);
            graph2.draw(drawQuadCurve);
            graph2.fill(new Rectangle2D.Float(10, 10, 150, 100));
            graph2.fill(drawTransRect);
        }
    }
}