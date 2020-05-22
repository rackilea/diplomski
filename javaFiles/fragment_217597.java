public class ExamplePanel extends JPanel
{
    Rectangle2D.Double selectionRect;
    Point mouseDown, mouseHere;

   ...

    protected void paintComponent(Graphics g)
    {
        AlphaComposite ta = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
        g2d.setComposite(ta);
        g2d.setColor(Color.BLUE);
        g2d.fill(selectionRect);
        g2d.setComposite(AlphaComposite.SrcOver);
        g2d.setColor(Color.BLACK);
        g2d.draw(selectionRect);
    }
}

public class ExammpleMouseListener extends MouseAdapter    
{    
    @Override
    public void mousePressed(MouseEvent e)
    {      
        super.mousePressed(e);

        // store the mouse down location
        pnl.mouseDown = e.getPoint();
    }

    /**
     * @see  java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {
        super.mouseDragged(e);

        // check for left mouse button
        if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) == 0)
        {
            return;
        }

        // store the current location
        pnl.mouseHere = e.getPoint();

        // calculate the size of the selection rectangle
        double downX = pnl.mouseDown.getX();
        double downY = pnl.mouseDown.getY();
        double hereX = pnl.mouseHere.getX();
        double hereY = pnl.mouseHere.getY();

        double l = Math.min(downX, hereX);
        double t = Math.min(downY, hereY);
        double w = Math.abs(downX - hereX);
        double h = Math.abs(downY - hereY);

        pnl.selectionRect = new Rectangle2D.Double(l, t, w, h);

        // queue a repaint of the panel
        pnl.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        super.mouseReleased(e);

        // clear the selection rectangle
        pnl.selectionRect = null;

        // queue a repaint of the panel
            pnl.repaint();
        }
    }
}