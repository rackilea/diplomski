Graphics2D g2d = alphaMask.createGraphics();
LinearGradientPaint lgp = new LinearGradientPaint(
        new Point(0, 0), 
        new Point(alphaMask.getWidth(), 0), 
        new float[]{0, 1}, 
        new Color[]{new Color(0, 0, 0, 255), new Color(0, 0, 0 , 0)});
g2d.setPaint(lgp);
g2d.fillRect(0, 0, alphaMask.getWidth(), alphaMask.getHeight());
g2d.dispose();