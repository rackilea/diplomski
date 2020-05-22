import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GrafikPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;
        //
        int rowOffset = width/10;
        int colOffset = height/10;
        int squareWidth = width/10;
        //
        int lines = 0;
        while(lines < 8){

            int squares = 0;

            while(squares < 8){
                if(squares%2 == 0)
                {
                    g.setColor(lines%2 != 0 ? Color.BLACK : Color.WHITE);
                }
                else
                {
                    g.setColor(lines%2 != 0 ? Color.WHITE : Color.BLACK);
                }
                g.fillRect(rowOffset+(squares*squareWidth), colOffset+(lines*squareWidth), squareWidth, squareWidth);
                //
                squares++;
            }

            lines++;
        }
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500, 500);
    }
}