@Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALI‌​AS_ON);
        float gradientPerc = (float)gradientSize/getHeight();
        LinearGradientPaint lgp = new LinearGradientPaint(0,0,0,getHeight()-1,
           new float[] {0, gradientPerc, 1-gradientPerc, 1f},
           new Color[] {lighterColor, darkerColor, darkerColor, lighterColor});
        g2.setPaint(lgp);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1,
            gradientSize, gradientSize);
        g2.setColor(edgeColor);
        g2.setStroke(edgeStroke);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1,
            gradientSize, gradientSize);
    }