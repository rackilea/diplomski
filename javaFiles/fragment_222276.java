import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import swing_tests.PaintGUI.SHAPE;

public class GUIPaint {

    private PaintGUI paintGUI;

    public void showGui() {

        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paintGUI = new PaintGUI();
        content.add(paintGUI, BorderLayout.CENTER);

        // create controls to apply colors and call clear feature
        JPanel controls = new JPanel();

        //todo: reduce duplicate code by having a method that constructs
        //and adds a button
        //todo: use button groups where only one button can be selected 
        JButton clearBtn = new JButton("Clear");
        JButton blackBtn = new JButton("Black");
        JButton redBtn = new JButton("Red");
        JButton magentaBtn = new JButton("Magenta");
        JButton lineBtn = new JButton("Line");
        JButton filledRectangleBtn = new JButton("Filled Rectangle");
        JButton thickBtn = new JButton("Thick Line");
        JButton thinBtn = new JButton("Thin Line");

        //todo: register an Action listner to each button by using lambda
        //for example   clearBtn.addActionListener(e-> paintGUI.clear());
        ActionListener actionListener = e -> {
            if (e.getSource() == clearBtn) {
                paintGUI.clear();
            }else if (e.getSource() == thinBtn) {
                paintGUI.thin();
            } else if (e.getSource() == thickBtn) {
                paintGUI.thick();
            } else if (e.getSource() == blackBtn) {
                paintGUI.black();
            } else if (e.getSource() == redBtn) {
                paintGUI.red();
            } else if (e.getSource() == magentaBtn) {
                paintGUI.magenta();
            } else if (e.getSource() == filledRectangleBtn) {
                paintGUI.setShape(SHAPE.RECTANGLE);
            } else if (e.getSource() == lineBtn) {
                paintGUI.setShape(SHAPE.LINE);
            }
        };

        clearBtn.addActionListener(actionListener);
        blackBtn.addActionListener(actionListener);
        redBtn.addActionListener(actionListener);
        magentaBtn.addActionListener(actionListener);
        lineBtn.addActionListener(actionListener);
        filledRectangleBtn.addActionListener(actionListener);
        thickBtn.addActionListener(actionListener);
        thinBtn.addActionListener(actionListener);

        controls.add(lineBtn);
        controls.add(filledRectangleBtn);
        controls.add(thinBtn);
        controls.add(thickBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(clearBtn);

        content.add(controls, BorderLayout.NORTH);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new GUIPaint().showGui());
    }
}

class PaintGUI extends JComponent {

    //states defined by enum
    enum SHAPE {RECTANGLE, LINE}

    private SHAPE shape; // store state
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private int startX, startY, endX, endY;  //shape coordinates
    private Color color = Color.BLACK;       //draw color
    private BasicStroke stroke = new BasicStroke(3); //draw stroke
    private boolean isClear = false;

    public PaintGUI() {

        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //save coord x,y where mouse was pressed
                startX = e.getX();
                startY = e.getY();
                endX = startX; endY = startY;
                clear(); //clear draw board
            }

        });

        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                    //update end coord as mouse dragged
                    endX = e.getX();
                    endY = e.getY();
                    repaint();  //keep repainting while drag lasts 
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        // draw white on entire draw area to clear
        g2.setColor(BACKGROUND_COLOR);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        if(isClear || shape == null){
            isClear = false;
            return;
        }

        //draw using color , stroke and shape attributes 
        g2.setColor(color);   
        g2.setStroke(stroke);

        switch (shape){
            case RECTANGLE:
                drawFilledRectangle(g2);
                break;
            case LINE:
                drawLine(g2);
                break;
            default:
                break;
        }
    }

    public void clear() {
        isClear = true;
        repaint();
    }

    public void drawLine(Graphics2D g2) {
        g2.drawLine( startX, startY, endX, endY);
        repaint();
    }

    public void drawFilledRectangle(Graphics2D g2) {
        //to allow rectangle dragged from bottom up and left to right
        //use min x and min y as origin
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int width = Math.abs(endX-startX);  //to account for negative width
        int height = Math.abs(endY-startY); //or height
        g2.fillRect(x,y,width,height);
    }

    public void thin() {
        setStroke(3);
    }

    public void thick() {
        setStroke(10);
    }

    public void setStroke(int width) {
        stroke  = new BasicStroke(width);
        repaint();
    }

    public void red() {
        setColor(Color.red);
    }

    public void black() {
        setColor(Color.black);
    }

    public void magenta() {
        setColor(Color.magenta);
    }

    void setColor(Color color){
        this.color = color;
        repaint();
    }

    void setShape(SHAPE shape) {
        this.shape = shape;
        clear();
    }
}