public static BufferedImage resize(BufferedImage img, int newW, int newH){ 
    int w = img.getWidth();  
    int h = img.getHeight();

    double thumbRatio = (double) newW / (double) newH;
    int imageWidth = img.getWidth(null);
    int imageHeight = img.getHeight(null);
    double aspectRatio = (double) imageWidth / (double) imageHeight;

    //PORTRAIT CASE
    if (h > w)
    {
        if (thumbRatio < aspectRatio) {
            newH = (int) (newW / aspectRatio);
        }
        else {
            newW = (int) (newH * aspectRatio);
        }
        BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();  
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();

        JFrame frame = new JFrame();
        JLayeredPane lpane = new JLayeredPane();
        JPanel panelBlue = new JPanel();
        JPanel panelGreen = new JPanel();

            frame.setPreferredSize(new Dimension(1024, 768));
            frame.setLayout(new BorderLayout());
            frame.add(lpane, BorderLayout.CENTER);

            lpane.setBounds(0, 0, 1024, 768);

            panelBlue.setBackground(Color.WHITE);
            panelBlue.setBounds(0, 0, 1024, 768);
            panelBlue.setOpaque(true);

            panelGreen.setBackground(Color.GREEN);
            panelGreen.setBounds(0, 0, 1024, 768);
            panelGreen.setOpaque(true);

            lpane.add(panelGreen, new Integer(0), 0);
            lpane.add(panelBlue, new Integer(1), 0);              


            ImageIcon imgg = new ImageIcon(dimg);
            JLabel label = new JLabel("", imgg, JLabel.CENTER);
            panelBlue.add( label, BorderLayout.CENTER );


            frame.pack();
            frame.setVisible(true);


            BufferedImage bi = new BufferedImage(1010, 740, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bi.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            lpane.paint(g2);
            g2.dispose();
            return bi;
    }
    //PORTRAIT CASE


    if (thumbRatio < aspectRatio) {
        newH = (int) (newW / aspectRatio);
    }
    else {
        newW = (int) (newH * aspectRatio);
    }

    if (w > 1024 || h > 768) {
    BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());
    Graphics2D g = dimg.createGraphics();  
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
    g.dispose();

    return dimg;
    }else return img;
}