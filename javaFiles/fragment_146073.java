BufferedImage master = ImageIO.read(new File("/Volumes/Disk02/Dropbox/MegaTokyo/thumnails/megatokyo_omnibus_1_3_cover_by_fredrin-d4oupef.jpg"));

    int diameter = Math.min(master.getWidth(), master.getHeight());
    BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = mask.createGraphics();
    applyQualityRenderingHints(g2d);
    g2d.fillOval(0, 0, diameter - 1, diameter - 1);
    g2d.dispose();

    BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
    g2d = masked.createGraphics();
    applyQualityRenderingHints(g2d);
    int x = (diameter - master.getWidth()) / 2;
    int y = (diameter - master.getHeight()) / 2;
    g2d.drawImage(master, x, y, null);
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
    g2d.drawImage(mask, 0, 0, null);
    g2d.dispose();

    JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(masked)));