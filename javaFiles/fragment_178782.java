import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Mosaic extends JPanel{

    private int width, height;
    private int ruut; // square 
    private int w = width / 2, h = height / 2; // middle of the app 
    private BufferedImage buffer;

    Random rand = new Random();
    Color color;

    public Mosaic(){
        this(500, 300, 10);     
    }

    public Mosaic(int width, int height, int ruut){
        this.width = width;
        this.height = height;
        this.ruut = ruut;
        this.buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setBackground(Color.BLACK); 
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(false);
        new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveNext(buffer.getGraphics());
            }
        }).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(buffer, 0, 0, this);
    }

    //next square
    public void moveNext(Graphics g){       

        int r = rand.nextInt(4);        

        switch (r) {
        case 1:
            h += ruut;
            wallTest();
            break;
        case 2:
            h -= ruut;
            wallTest();
            break;
        case 3:
            w -= ruut;
            wallTest();
            break;
        case 4:
            w -= ruut;
            wallTest();
            break;
        }

        color = new Color(0, rand.nextInt(255-50)+50, 0);
        g.setColor(color);
        g.fillRect(w, h, ruut, ruut);
        repaint();
    }

    public void wallTest(){
        if (h > height){
            h = 0;
        }
        if (h < 0){
            h = height;
        }
        if (w > width){
            w = 0;
        }
        if (w < 0){
            w = width;
        }
    }   
}