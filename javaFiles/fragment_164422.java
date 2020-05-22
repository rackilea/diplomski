public void paint(Graphics g)
{

            Graphics2D g2 = (Graphics2D)g.create();
                 // note, we are creating a graphics object here for safe painting
            LinearGradientPaint p=new LinearGradientPaint(0,0,0,height,new float[]{0f,1f},new Color[]{new Color(0.2498f,0.2498f,0.2498f,0.3f),new Color(0.1598f,0.1598f,0.1598f,0.8f)});
            g2.setPaint(p);
            g2.fillRect(0, 0, width,height);
            g2.dispose(); // disposing the object which we created 

            super.paint(g);

    }