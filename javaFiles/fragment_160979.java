addMouseWheelListener(new MouseWheelListener()
{

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int rotation = e.getWheelRotation();
        if (rotation < 0)
        {
            scale -= scaleDelta;
        }
        else
        {
            scale += scaleDelta;
        }
        if (scale < 0)
        {
            scale = 0;
        }
        //                    else if (scale > 1.5) {
        //                        scale = 1;
        //                    }
        scalePoint.setText("Scale: " + String.valueOf(scale));

        repaint();

        //                    System.out.println(getSize());
    }
});

addMouseMotionListener(new MouseMotionListener()
{
    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (isNewLine == false)
        {
            xend = e.getX();
            yend = e.getY();

            //NEW
            Point2D p = calcCoordinates(e);
            xend = (int) p.getX();
            yend = (int) p.getY();

            end.setText("End Values : " + xend + " " + yend);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        lbl.setText("Mouse Point: " + e.getX() + " " + e.getY());
        if (isNewLine == false)
        {
            xend = e.getX();
            yend = e.getY();

            //NEW
            Point2D p = calcCoordinates(e);
            xend = (int) p.getX();
            yend = (int) p.getY();

            repaint();
        }
    }

});

addMouseListener(new MouseAdapter()
{

    @Override
    public void mouseReleased(MouseEvent e)
    {
        System.out.println(e.getX() + " " + e.getY() + "mouse");
        if (isNewLine == true)
        {
            xbegin = xend = e.getX();
            ybegin = yend = e.getY();

            //NEW
            Point2D p = calcCoordinates(e);
            xbegin = xend = (int) p.getX();
            ybegin = yend = (int) p.getY();

            isNewLine = false;
            box = new Rectangle2D.Float(xend - 5, yend - 5, 12, 12);

            boxContainer.add(box);
        }
        else
        {

            linebuffer = new Line2D.Float((float) xbegin, (float) ybegin, (float) xend, (float) yend);

            System.out.println("xbegin: " + xbegin + " " + ybegin + " " + xend + " " + yend);
            lineContainer.add(linebuffer);

            repaint();

            xbegin = e.getX();
            ybegin = e.getY();

            //NEW
            Point2D p = calcCoordinates(e);
            xbegin = (int) p.getX();
            ybegin = (int) p.getY();

            if (box.contains(xend, yend))
            {
                xend = (int) box.getCenterX();
                yend = (int) box.getCenterY();
                isNewLine = true;
                return;
            }

            box = new Rectangle2D.Float(xend - 6, yend - 6, 12, 12);

            boxContainer.add(box);
            return;
        }
    }