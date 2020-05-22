public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        LinearGradientPaint p=new LinearGradientPaint(0,0,0,height,new float[]{0f,1f},new Color[]{new Color(0.2498f,0.2498f,0.2498f,0.3f),new Color(0.1598f,0.1598f,0.1598f,0.8f)});
        g2.setPaint(p);
        g2.fillRect(0, 0, width,height);
    }