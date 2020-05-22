//listeners for dragging
    void addListeners(Component button)
    {
        button.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {   
            //Only drag if a slider was selected
            if (draggingFirst)
            {
                //update position of silder
                firstSlider = snapToEdge(evt.getPoint(), evt.getComponent());
                evt.getComponent().repaint();
            }
            else if (draggingSecond)
            {
                //update position of silder
                secondSlider = snapToEdge(evt.getPoint(), evt.getComponent());
                evt.getComponent().repaint();
            }
            }
        });
        button.addMouseListener(new java.awt.event.MouseAdapter()
        {
            //check if a slider was selected
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
            if (isInside(evt.getPoint(), firstSlider))
            {
                draggingFirst = true;
            }
            else if (isInside(evt.getPoint(), secondSlider))
            {
                draggingSecond = true;
            }
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
            //cancel selected slider
            draggingFirst = false;
            draggingSecond = false;
            }
        });
    }