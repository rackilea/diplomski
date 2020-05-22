import java.awt.*;
import javax.swing.*;

public class CardFrame {
    enum CardColor{red,black};
    enum CardSuit{heart,diamond,spade,club}
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JPanel cardDisplay = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(50,100);
                    }
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        draw(g,0,0);
                    }

                    private int width = 50;
                    private int height = 80;

                    private boolean faceUp() {
                        return true;
                    }
                    private CardColor color() {
                        return CardColor.red;
                    }
                    private CardSuit suit() {
                        return CardSuit.heart;
                    }
                    private int rank() {
                        return 0;
                    }
                    private String[] names = {"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
                    private void draw(Graphics g, int x, int y) {
                        // clear rectangle, draw border
                        g.clearRect(x, y, width, height);
                        g.setColor(Color.black);
                        g.drawRect(x, y, width, height);

                        // draw body of card
                        if (faceUp()) {
                            if (color() == CardColor.red)
                                g.setColor(Color.red);
                            else
                                g.setColor(Color.black);

                            g.drawString(names[rank()], x + 3, y + 15);

                            if (suit() == CardSuit.heart) {
//                              g.drawLine(x + 25, y + 30, x + 35, y + 20);
//                              g.drawLine(x + 35, y + 20, x + 45, y + 30);
//                              g.drawLine(x + 45, y + 30, x + 25, y + 60);
//                              g.drawLine(x + 25, y + 60, x + 5, y + 30);
//                              g.drawLine(x + 5, y + 30, x + 15, y + 20);
//                              g.drawLine(x + 15, y + 20, x + 25, y + 30);
                                int[] xPoints = new int[]{x + 5,x + 15,x + 25,x + 35,x + 45,x + 25};
                                int[] yPoints = new int[]{y + 30,y + 20,y + 30,y + 20,y + 30,y + 60};
                                g.fillPolygon(xPoints, yPoints, 6);
                            } else if (suit() == CardSuit.spade) {
                                // ...
                            } else if (suit() == CardSuit.diamond) {
                                // ...
                            } else if (suit() == CardSuit.club) {
                                //
                            }
                        } else // face down
                        {
                            // ...
                        }
                    }
                };

                JFrame frm = new JFrame();
                frm.setContentPane(cardDisplay);
                frm.pack();
                frm.setVisible(true);
            }
        });
    }
}