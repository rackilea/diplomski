package prueba_uno_graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Uriel
 */
// Don't mix heavy and light weight components
public class Dibujo extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

//    ArrayList lineas = new ArrayList();
//    boolean m_alzada = true, is_beginning = true, to_save = false;
//    int uX, uY, x, y;

    private Path2D shape;

    Dibujo() {
        setBackground(Color.WHITE);
        shape = new Path2D.Float();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D draw = (Graphics2D) g;
//        if (this.is_beginning || this.to_save) {
//            draw.setColor(Color.white);
//            draw.fillRect(0, 0, this.getWidth(), this.getHeight());
//            this.is_beginning = false;
//        }
//        if (this.m_alzada) {
//            draw.setColor(Color.red);
//            draw.drawLine(uX, uY, x, y);
//
//        }

        draw.setColor(Color.RED);
        draw.draw(shape);

    }

//    @Override
//    public void paint(Graphics g) {
//        // ALWAYS call super.paint
//        super.paint(g);
//        Graphics2D draw = (Graphics2D) g;
//        if (this.is_beginning || this.to_save) {
//            draw.setColor(Color.white);
//            draw.fillRect(0, 0, this.getWidth(), this.getHeight());
//            this.is_beginning = false;
//        }
//        if (this.m_alzada) {
//            draw.setColor(Color.red);
//            draw.drawLine(uX, uY, x, y);
//
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //        this.uX = e.getX();
        //        this.uY = e.getY();
        Point point = e.getPoint();
        shape.moveTo(point.x, point.y);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //        this.x = e.getX();
        //        this.y = e.getY();
        // Don't do this!
        //        this.paint(this.getGraphics());
        //        ArrayList ayuda = new ArrayList();
        //        ayuda.add(uX);
        //        ayuda.add(uY);
        //        ayuda.add(x);
        //        ayuda.add(y);
        //        this.lineas.add(ayuda);
        //        uX = x;
        //        uY = y;
        Point point = e.getPoint();
        shape.lineTo(point.x, point.y);
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}